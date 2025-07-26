package CollectionFrameworks;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample extends Thread{
    static Map<Integer, String> l = new ConcurrentHashMap<>();
    ConcurrentHashMapExample(String name){
        super(name);
    }
    public void run(){
        System.out.println(Thread.currentThread().getName()+" is trying to concurrent modification!!");
        try{
            Thread.sleep(2000);
        } catch (Exception e) {

        }
        l.put(100, "Modified"); //modification
    }
    public static void main(String args[]){
        //ConcurrentHashMap uses segment level or bucket level locking for all write operations and read operations do not need any locking hence it means multiple readers can read at the same time also if a writer is writing on a bucket and reader wants to read then it can do if writer is not doing any structural changes because readers use CAS(compare and swap algo for reading data).

        //There is concurreny level which means the number of concurrency levels will be the segments in which this map will be divided for locking.

        //Default buckets in a map are 16 and if we set concurrency level to 16 then it will become bucket level locking.

        //Not allowed null key as well as null value

        //if there is a reader reading some data from a concurrentHashMap and a writer writes something simultaneously then previously we have seen concurrentModificationException comes in normal HashMaps but here in this case no exception will come.

        /*

        Constructors:

        Map<Integer, String> mp = new ConcurrentHashMap<>(); default initial capacity(16), default load factor(0.75), default concurrencyLevel(16)

        Map<Integer, String> mp = new ConcurrentHashMap<>(20); custom initial capacity(20), default load factor(0.75), default concurrencyLevel(16)

        Map<Integer, String> mp = new ConcurrentHashMap<>(20, 0.50); custom initial capacity(20), custom load factor(0.5), default concurrencyLevel(16)

        Map<Integer, String> mp = new ConcurrentHashMap<>(20, 0.50, 8); custom initial capacity(20), custom load factor(0.5), custom concurrencyLevel(8)
         */

        //Demonstration for above point:

        l.put(1, "Manas");
        l.put(2, "ABC");
        l.put(3, "XYZ");
        ConcurrentHashMapExample t1 = new ConcurrentHashMapExample("Modifier");
        t1.start();
        Iterator<Map.Entry<Integer, String>> it = l.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer, String> obj= it.next();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+" has readed the value: "+obj.getKey());
        }
        //In ConcurrentHashMap, concurrent modifications are allowed without exception. However, an iterator is weakly consistent, so if a writer thread adds an entry after the iterator has moved past that bin, the iterator won’t see it; if the bin is yet to be visited, it may see the new entry.
    }
}