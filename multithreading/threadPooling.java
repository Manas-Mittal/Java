package multithreading;
import java.util.concurrent.*;
class PrintJob implements Runnable{
    String name;
    public PrintJob(String val){
        name = val;
    }
    public void run(){
        System.out.println(name+" job is executed by "+Thread.currentThread().getName());
    }
}
public class threadPooling {
    public static void main(String args[]) {
        /*
        Creating a new thread for every job may create performance or memory problems.

        to overcome this we should go for thread pool.

        thread pool is a pool of already created threads ready to do our job.

        java 1.5 version introduced thread pool framework to implement thread pools.

        thread pool framewrok aka executor framework.

        */

        ExecutorService service = Executors.newFixedThreadPool(3); //creating a thread pool of 3 threads.

        //Submitting a runnable job to the pool

        // service.submit(job);

        //we can shutdown executor service by using 
        // service.shutdown();

        //Demo Code

        PrintJob jobs[] = {
            new PrintJob("Job-1"),
            new PrintJob("Job-2"),
            new PrintJob("Job-3"),
            new PrintJob("Job-4"),
            new PrintJob("Job-5"),
            new PrintJob("Job-6")
        };
        for(PrintJob job: jobs){
            service.submit(job);//submit each job to the executor with a fixed number of threads that is 3, without executor we would have to create a new thread for every job that would have taken 6 threads but now 6 jobs are being done by 3 threads only.
        }
        service.shutdown();//all threads in the pool will be terminated

        //while designing web servers and application servers we can use thread pool concept for serving requests without creating burden on server.

        /*

        Runnable vs Callable:
        incase of Runnable we override run method and the return tyoe of run method is void because in that case we dont expect our thread to return something.

        also incase of runnnable we cant use throws keyword with run method

        Callable:

        Callable generic functional interface has public T call() method wehich we override and we use Callable when we expect our thread to return something.

        also we can use throws keyword with call method.

        NOTE -> Callable can only be used with ExecutorService and not with Thread class.
        Runnable can be used with both.
        */

        /*
        How Callable and Future works together alongwith ExecutorService:
        
        1. When we want our threads to return something we give Callable job instead of Runnable job.

        2. interface Callable <T>{
            public T call() throws Exception;
        }
        3. Callable is generic as we can work with any type of Data that we want.

        4. as we submit a Callable task to the executorService it immediately returns an empty future object of our specified return type, it does this because then main thread will continue the rest of code and executor will continue to execute task in the background making it async.

        5. we can get the result using future.get(), is the result is ready it will be returned immediately but if not the thread executing future.get() will wait that is blocked and not perform rest code untill result is not fetched.

        6. Future interface provides us various methods like get(), isDone(), cancel() to track our tasks.

        Program demonstrating use of Future, Callable with ExecutorService:

            public class demo{
            
                public static void main(String args[]){
                
                    ExecutorService executor = Executors.newSigleThreadExecutor();

                    Callable<String> task = new Callable<String>()>{

                        public String call(){
                            Thread.sleep(2000);
                            return "Hello from Callable";
                        }
                    }
                    Future<String> future = executor.submit(task);

                    sout("Main thread is free to do other work!!");

                    String result = future.get();

                    sout("Result from Callable: "+result);
                    executor.shutdown();
                }
            
            }
        */
        
    }
}
