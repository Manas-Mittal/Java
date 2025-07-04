package multithreading;
class thread extends Thread{
    public thread(String name){
        super(name);
    }
    public void run(){
        System.out.println(Thread.currentThread().getName()+" is running");
        try {
            Thread.sleep(5000); //wait state
        } catch (Exception e) {
        } //Running state
    }
}
public class statesOfThread {
    public static void main(String args[]){
        thread t1 = new thread("Thread-1"); 
        System.out.println(t1.getState()); //New
        t1.start();
        System.out.println(Thread.currentThread().getState()); //Runnable
        try {
            t1.join(); //main thread waits for t1 to finish
        } catch (InterruptedException ex) {

        }
        System.out.println(t1.getState()); //Terminated, as t1 finished then main came here
    }
}
