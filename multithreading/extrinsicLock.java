package multithreading;
import java.util.concurrent.locks.*;
class bank{
    int balance = 100;
    Lock lock = new ReentrantLock();
    public void withdraw(int amount){
        //tryLock method returns true if lock is available and false if not and if the lock is available the thread can enter inside the block and then lock variable sets to false again

        //we can also do lock.tryLock(time in milliseconds) the thread executing this will wait for specified time and then try to acquire the lock. But here as the thread goes in waiting state we need to try catch when using timed tryLock.
        if(lock.tryLock()){
            try{
                System.out.println(Thread.currentThread().getName()+" is working on a transaction");
                if(amount > balance){
                    System.out.println("Insufficient Funds");
                }else{
                    balance = balance - amount;
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                    }
                    System.out.println("Available balance: "+balance);
                }
            }
            catch(Exception e){}
            finally{
                lock.unlock(); //makes the locks variable true
            }
        }
        else{
            System.out.println(Thread.currentThread().getName()+" is exiting without acquiring the lock");
        }
    }
}
class thread extends Thread{
    bank obj;
    public thread(bank ref, String name){
        super(name);
        obj = ref;
    }
    public void run(){
        obj.withdraw(50);
    }
}
public class extrinsicLock {
    public static void main(String args[]){
        bank obj = new bank();
        thread t1 = new thread(obj, "Thread-1");
        thread t2 = new thread(obj, "Thread-2");
        t1.start();
        t2.start();
    }
}
//some important points:
/* 
 we can use lock.lock() or lock.tryLock() to acquire lock, lock.lock() leads a thread to wait for the lock to be get available but tryLock() means try to acquire lock if avaialable okay if not then return from here without waiting.
 
 Lock lock = new ReentrantLock(true); // true = fairness, it will lead to allow the threads to try for the lock in a fifo manner that is the longest waiting thread will try first.

 lock.isLocked() : no matter which thread executes this line it will only tell is the lock acquired by somebody or not

 lock.isHeldByCurrentThread(): it will tell that lock acquired by the thread executing this line or not

*/