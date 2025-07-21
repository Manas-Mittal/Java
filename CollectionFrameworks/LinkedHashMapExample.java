package CollectionFrameworks;
import java.util.*;
public class LinkedHashMapExample {
    public static void main(String args[]){
        LinkedHashMap<Integer, String> lhm = new LinkedHashMap<>();

        //linkedhashmap extends HashMap and its exactly same to it just the differnce is LinkedHashMap maintaines the order of the entries in the way they got stored by using a doubly linked list.
        
        //LinkedHashMap is recommedned to use when order matters because its expensive in terms of memory due to its separate doubly linked list to maintain the order.

        //LRU cache implementation using LinkedHashMap

        /*

        in the constructor of the LinkedHahsMap we can give initialCapacity, loadFactor just like HashMap but also a third value that is accessOrder its a bollean value either true or false.

        when its false the order of doubly linked list is by default according to the insertion order but when its true:

        the recently used once comes in the last and the least used ones comes in the front and thats how implementing LRU cache is easy with LinkedHashMap.

        */
    }
}
