package multithreading;
import java.util.Scanner;
import java.util.concurrent.*;
//public static void main(String args[]){
//semaphores are synchronization technique that works on permits a thread must acquire a permit before entering into a block and if permit is not available it must wait for it.

//after the workdone thread must release the permit so that other threads can also enter.
//permits are like tickets to a place while entering. For eg: if there is a room with only 2 permits and 5 people wants to enter then first acquire permits and then they can go so at a time only 2 people can be there inside room and others will wait, also after a person moves out from a room he will release his permit so that any other person can acquire it.
/*
//Constructors:
//Semaphore sem = new Semaphore(int permits);
//Semaphore sem = new Semaphore(int parties, bool fair) here if fair is true it means threads will enter in fifo order
//         */
//         //Sample program.
//         Semaphore sem = new Semaphore(2);
//         Runnable task = () -> {
//             System.out.println(Thread.currentThread().getName()+" is trying to get the permit");
//             try {
//                 sem.acquire();
//             } catch (InterruptedException e) {
//             }
//             System.out.println(Thread.currentThread().getName()+" has got the permit");
//             //doing some work
//             try {
//                 Thread.sleep(3000);
//             } catch (Exception e) {
//             }
//             System.out.println(Thread.currentThread().getName()+" has done the work.");
//             sem.release();
//         };
//         Thread t1 = new Thread(task, "Thread-1");
//         Thread t2 = new Thread(task, "Thread-2");
//         Thread t3 = new Thread(task, "Thread-3");
//         t1.start();
//         t2.start();
//         t3.start();
//     }
// }
//Program to print a pattern 010203040506..... till specified 'n' using three threads one prints 0, other one prints odd numbers and remaining will print even number.

/*

Here in this question we have three tasks which needs to be done in an order hence we will use semaphores because semaphore object can be acquired by any thread and that thread can release the anyother semaphore object hence this question can be done as:

Three threads -> tzero(will execute methods priting 0), teven(will execute method printing even no.), todd(will execute method printing odd numbers)

three semaphores -> semZero(to enter in zero printing method initially will have 1 permit), semOdd(to enter in method printing odd numbers initially will 0 permits), semEven(to enter in method printing even numbers, inititally it will have 0 permits)

tzero.start();
teven.start();
todd.start();

tzero entered in respective method(teven and todd cant as semOdd and semZero had 0 permits initially) -> tzero then released semOdd(semZero remains 0 and on releasing semOdd became 1 hence todd got in) -> todd again released semZero(semOdd remains 0 and on releasing semZero it became 1) -> hence the pattern will go on.


so thats how a thread can acuire a semaphore and it can release the other semaphore object.

 */
class tzero extends Thread {
    Semaphore semZero, semOdd, semEven;
    String name;
    int n;
    volatile boolean isEven = false;
    public tzero(Semaphore semZero, Semaphore semEven, Semaphore semOdd, int n, String name) {
        super(name);
        this.semZero = semZero;
        this.semEven = semEven;
        this.semOdd = semOdd;
        this.n = n;
    }
    public void run() {
        for (int i = 1; i <= n; i++) {
            try {
                semZero.acquire();
            } catch (InterruptedException e) {
            }
            System.out.print(0);
            if (isEven == false) {
                isEven = !isEven;
                semOdd.release();
            } else {
                isEven = !isEven;
                semEven.release();
            }
        }
    }
}
class todd extends Thread {
    Semaphore semZero, semOdd;
    String name;
    int n;
    public todd(Semaphore semZero, Semaphore semOdd, int n, String name) {
        super(name);
        this.semOdd = semOdd;
        this.semZero = semZero;
        this.n = n;
    }
    public void run() {
        for (int i = 1; i <= n; i += 2) {
            try {
                semOdd.acquire();
            } catch (Exception e) {
            }
            System.out.print(i);
            semZero.release();
        }
    }
}
class teven extends Thread {
    Semaphore semZero, semEven;
    String name;
    int n;
    public teven(Semaphore semZero, Semaphore semEven, int n, String name) {
        super(name);
        this.semEven = semEven;
        this.semZero = semZero;
        this.n = n;
    }

    public void run() {
        for (int i = 2; i <= n; i += 2) {
            try {
                semEven.acquire();
            } catch (Exception e) {
            }
            System.out.print(i);
            semZero.release();
        }
    }
}

public class semaphoreExample {
    public static void main(String args[]) {
        int n;
        System.out.print("Enter the number on which pattern should end: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Semaphore semZero = new Semaphore(1);
        Semaphore semEven = new Semaphore(0);
        Semaphore semOdd = new Semaphore(0);
        tzero t1 = new tzero(semZero, semEven, semOdd, n, "ThreadZero");
        teven t2 = new teven(semZero, semEven, n, "ThreadEven");
        todd t3 = new todd(semZero, semOdd, n, "ThreadOdd");
        t1.start();
        t2.start();
        t3.start();
    }
}
