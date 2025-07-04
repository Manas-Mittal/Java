package multithreading;
class shared{
    int counter = 0;
    //any one thread can enter in synchronized block at a time and perform operations using objects intrinsic locks.
    //one thread goes inside acquires lock on that object then other thread wait in the entry set then previous thread releases the lock and other threads can come inside this is how only one thread can enter inside synchronized method or block and others will wait outisde.
    public synchronized void increase(){
        System.out.println(Thread.currentThread().getName()+" is running");
        counter++;

        //example of synchronized block
        /* synchronized(this){

        }
        */
        
        //we can also have a non synchronized method with a synchronized block and hence multiple threads can enter insdie the methods flow but only at a time can enter inside synchronize block
    }
    
    public int getCount(){
        return counter;
    }
}
class thread extends Thread{
    shared obj;
    public thread(shared ref, String name){
        super(name);
        obj = ref;
    }
    public void run(){
        obj.increase();
    }
}
public class synchronizeKeyword {
    public static void main(String args[]){
        shared obj = new shared();
        thread t1 = new thread(obj, "Thread-1");
        thread t2 = new thread(obj, "Thread-2");
        t1.start();
        t2.start();
    }
}

//Some important points:
/*
 * static synchronized block or method does depend on any particular object and hence if there are multiple threads working on different objects and if one thread is insdie this method or block other threads will have to wait
 * 
 * synchronized blocks or methods always guarantee data consistencey that is the threads will always see the updated value of shared variable because every thread reads the variable value from memory and not from its cached memory hence one thread does operation and wruites the updated back in the memory.
 * 
 * volatile keyword is only used for variables and it only ensures consistency and not atomicity which is what we get from synchronized block.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
