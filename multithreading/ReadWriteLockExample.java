package multithreading;

import java.util.concurrent.locks.*;

public class ReadWriteLockExample {

    // ReadWriteLock allows multiple readers or one writer at a time (not both).
    ReadWriteLock lock = new ReentrantReadWriteLock();

    // Separate lock objects for reading and writing.
    Lock reader = lock.readLock(); //getting instance of ReadLock class
    Lock writer = lock.writeLock(); //getting instance of WriteLock class

    int count = 0; // Shared resource

    // Writer method: Acquires writeLock which is exclusive (no other thread can read/write).
    public void increament() {
        writer.lock();  // Acquires the write lock
        try {
            count++;    // Critical section - only one thread allowed here
        } finally {
            writer.unlock();  // Must unlock in finally to avoid deadlocks
        }
    }

    // Reader method: Acquires readLock which is shared (multiple readers allowed).
    public int getCount() {
        reader.lock();  // Acquires the read lock
        try {
            return count;  // Critical section - multiple readers can enter
        } finally {
            reader.unlock();  // Must unlock in finally
        }
    }

    public static void main(String args[]) {

        ReadWriteLockExample obj = new ReadWriteLockExample();

        // Reader task: Simulates reading operation
        Runnable readTask = new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    obj.getCount();  // Read operation with lock
                    System.out.println(Thread.currentThread().getName() + " is reading.");
                }
            }
        };

        // Writer task: Simulates writing (incrementing count)
        Runnable writeTask = new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    obj.increament();  // Write operation with exclusive lock
                    System.out.println(Thread.currentThread().getName() + " is writing.");
                }
            }
        };

        // Creating threads for readers and writers
        Thread t1 = new Thread(readTask);
        Thread t2 = new Thread(readTask);
        Thread t3 = new Thread(writeTask);

        // Starting all threads
        t1.start();
        t2.start();
        t3.start();

        // Ensuring all threads finish before printing final result
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Final value of count after all writes
        System.out.println("Final Count: " + obj.count);
    }
}

/*

Lock and ReadWriteLock are two interfaces -> ReentrantLock is a class that implements Lock interface methods according to it and ReentrantreadWriteLock is a class that implements ReadWrite interface according to it.

ReentrantReadWriteLock contains two inner classes name ReadLock and WriteLock that implements Lock interface.

Doubt Question -> When ReadLock and WriteLock classes directly implements Lock interface then whats the need ReentrantReadWrite class ?

Answer -> ReadWriteLock provides two types of locks: readLock() and writeLock().
Multiple threads can acquire the read lock simultaneously, but the write lock is exclusive.
This ensures:
1) No readers can read while a writer is writing.
2) No writer can write while readers are reading or another writer is writing.
To coordinate between the read and write locks, we need a shared object that holds internal state like read count, write access flags, and waiting queues.
The ReentrantReadWriteLock class acts as this central coordinating object — it contains inner classes ReadLock and WriteLock, which both use the outer class's internal state to synchronize access properly.

 */
