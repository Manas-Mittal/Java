package multithreading;
import java.util.concurrent.locks.*;
public class ReentrantLockExample {
    Lock lock = new ReentrantLock();

    public void outerMethod(){
        lock.lock();
        System.out.println("Outer Method");
        innerMethod();
        lock.unlock();
    }
    public void innerMethod(){
        lock.lock();
        System.out.println("Inner Method");
        lock.unlock();
    }
    public static void main(String args[]){
        ReentrantLockExample obj = new ReentrantLockExample();
        obj.outerMethod(); //main thread calls this
    }
}
//Explanation:
/*
here we can see main thread is calling outer method.

inside outerMethod main thread acquires the lock and calls innerMethod.

now what should happen is the lock is already acquired so main thread should have waited for its own to release the lock and then it can go ahead inside innerMethod but its not the case:

ReentrantLock means one thread can hold lock more then one time and does not have to wait for its own so in this case main thread will aquire the lock 2 times

now ReentrantLock class maintaines a counter for every thread that how many times it acquired the lock on the same object and that many times we have to unlock it.

*/