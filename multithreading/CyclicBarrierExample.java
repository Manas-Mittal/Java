package multithreading;

import java.util.concurrent.CyclicBarrier;

class MyThread implements Runnable{
    CyclicBarrier barrier;
    int id;

    public MyThread(CyclicBarrier barrier, int id){
        this.barrier = barrier;
        this.id = id;
    }
    public void run(){
        System.out.println("Thread "+id+" is doing some work");
        try {
            Thread.sleep(id*1000);
            System.out.println("Thread "+id+" reached the barrier.");
            barrier.await();//wait for other ones to reach the barrier as well
            System.out.println("Thread "+id+" has passed the barrier.");
        } catch (Exception e) {
        }
    }

}
public class CyclicBarrierExample {
    public static void main(String args[]){
        /*
        CyclicBarriers are used in a scenerio where we want that every thread should wait for each other until they reach a common barrier point.

        Imagine 3 friends have to race but they say that when all the three will be ready then race will get started so they would wait for each other to get ready.

        Constructors:
        1. CyclicBarrier barrier = new CyclicBarrier(int parties); //here parties is the number of threads that must call await() before all are released.

        2. CyclicBarrier barrier = new CyclicBarrier(int parties, Runnable barrierAction); // here the second arguement is the Runnable object that is necessarily to be performed before releasing all the threads and it is performed by the last thread which calls await method.

        Methods:
        1. await() -> called by threasd to wait at the barrier.

        2. await(long timout, TimeUnit.unit) -> waits with a timeout.If all the threads doesnt arrive within this timeout then this thread will throw TimeOutException and all the other waiting threads will throw BrokenBarrierException.

        3. getParties() -> Returns the number of Threads required.

        4. getNumberWaiting() -> returns number of threads currently waiting.

        5. isBroken() -> returns true is the barrier is broken.

        6. reset() -> Resets barrier to its initial state. The barrier gets broken and hence all the waiting Threads will get a BrokenBarrierException.
        */

        /*

        Barrier objects resets itself to the intial values after all threads pass the barrier and unlike CountDown latch we can use that barrier object again.


        */
        int totalThreads = 3;
        CyclicBarrier barrier = new CyclicBarrier(totalThreads, ()->{
            System.out.println("All the threads have passed the barrier");
        });//barrier object creation including barrier action as well.
        for(int i=1;i<=totalThreads;i++){
            Thread t = new Thread(new MyThread(barrier, i));
            t.start();
        }
    }
}
