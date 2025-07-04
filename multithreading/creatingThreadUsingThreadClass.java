package multithreading;
class thread extends Thread{
    public thread(String name){
        super(name);
    }
    public void run(){
        //Thread-1
        System.out.println(Thread.currentThread().getName()+" is running");
    }
}
public class creatingThreadUsingThreadClass {
    public static void main(String args[]){
        //main thread
        thread t1 = new thread("Thread-1");
        t1.start();
    }
}
