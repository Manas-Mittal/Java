package multithreading;
class thread implements Runnable{
    public void run(){
        System.out.println(Thread.currentThread().getName()+" is running");
    }
}
public class creatingThreadUsingRunnable {
    public static void main(String a[]){
        thread obj = new thread();
        Thread t1 = new Thread(obj, "Thread-1");
        t1.start();
    }
}
