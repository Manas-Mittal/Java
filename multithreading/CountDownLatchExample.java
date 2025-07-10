package multithreading;

import java.util.concurrent.*;

public class CountDownLatchExample {
    public static void main(String args[]){
        /*
        CountDownLatch is synchronization technique whcih lets us to wait main thread or the other until a fixed number of threads complete their tasks.

        Its mainly used in the case of Executor Service when we dont have access to the thread objects thats why we cant use join in this case to make main thread wait.


        //Methods:
        await() -> causes the current thread to wait until the count reached to 0

        countDown() -> Decrements the count by 1

        getCount() -> Returns current count

        await(long timeout, TimeUnit.unit) -> waits upto the given time
        */
        int numberOfTask = 4;
        ExecutorService executor = Executors.newFixedThreadPool(2);
        CountDownLatch latch = new CountDownLatch(numberOfTask);
        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName()+" is doing the task");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread().getName()+" has finished doing its task");
            latch.countDown();
        };
        for(int i=0;i<numberOfTask;i++){
            executor.submit(task);
        }

        System.out.println("Main Thread waiting to complete all the tasks");

        try {
            latch.await();
        } catch (InterruptedException ex) {
        }
        System.out.println("All tasks completed, main thread resumes");
        executor.shutdown();
    }
}
