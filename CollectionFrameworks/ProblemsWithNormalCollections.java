package CollectionFrameworks;

import java.util.*;

public class ProblemsWithNormalCollections extends Thread{
    static ArrayList<Integer> l = new ArrayList<>();
    ProblemsWithNormalCollections(String name){
        super(name);
    }
    public void run(){
        System.out.println(Thread.currentThread().getName() + " is trying to modify the list");
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){

        }
        l.add(100);
    }
    public static void main(String args[]) throws InterruptedException {
        /*

        There are several problems with normal collections due to which we need to introduce concurrent collections some problems are :

        1) 90% of collections are not thread safe.

        2) we can create some of the existing collections as thread safe using Collections.synchronized but these will have performance issues such that only one thread will be able to perform operation at a time even if read is there.

        3) ConcurrentModificationException -> if one thread is reading from the collection and other thread modify something in it then ConcurrentModificationException will come because the current state of collection will not match to the iterators state which tracked using ModCount and expectedModCount.

        Program to demonstrate 3rd point.

         */
        l.add(1);
        l.add(2);
        l.add(3);
        ProblemsWithNormalCollections t1 = new ProblemsWithNormalCollections("Modifier");
        t1.start();
        Iterator<Integer> it = l.iterator();
        while(it.hasNext()){
            int val = it.next();
            System.out.println(Thread.currentThread().getName()+" has readed: "+val);
            Thread.sleep(3000);
        }
    }
}
