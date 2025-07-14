package multithreading;

import java.util.concurrent.*;

class MyCallable implements Callable<Integer> {
    Integer value;

    public MyCallable(Integer obj) {
        value = obj;
    }

    public Integer call() {
        int n = value.intValue();
        Integer answer = Integer.valueOf((n * (n + 1)) / 2);
        
        // Print which thread is handling this job
        System.out.println("Calculating sum for " + n + " by " + Thread.currentThread().getName());
        
        return answer;
    }
}

public class ExecutorServiceExample {
    public static void main(String args[]) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        MyCallable jobs[] = {
            new MyCallable(10),
            new MyCallable(20),
            new MyCallable(30),
            new MyCallable(40),
            new MyCallable(50),
            new MyCallable(60)
        };

        Future<Integer> answers[] = new Future[6];

        for (int i = 0; i < 6; i++) {
            answers[i] = executor.submit(jobs[i]);
        }

        // Now get the result from each Future
        for (int i = 0; i < 6; i++) {
            try {
                Integer result = answers[i].get();  // Waits for task to complete
                System.out.println("Result of task " + (i + 1) + ": " + result);
            } catch (Exception e) {
                System.out.println("Error in task " + (i + 1));
            }
        }

        executor.shutdown();  // Important: shut down the executor after use
    }
}
/*

Some important point on shutdown() , shutdownNow() and awaitTermination(time, TimeUnit.unit)

shutdown() is a non blocking call that is it doesnt blocks the main thread but after execution of this executor stops taking new tasks and when all the tasks gets finishes my executor object will not accept new tasks it can only be used to check status like executor.isDone().

shutdownNow() calls Thread.interrupt on all the running threads in the pool hence if explicit check by isInterrupted or handling interruptedException is not used then running threads will keep running otherwise shoutdownNow interruptes all running threads and stops the executor from taking new tasks also it returns the size of list containing those tasks that are in the queue to be done.

awaitTermination(time, TimeUnit.unit) -> this leads to block and wait main thread till executor finishes all the tasks. It should always be called after executor.shutdown().





*/