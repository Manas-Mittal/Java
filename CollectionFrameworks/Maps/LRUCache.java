package CollectionFrameworks;

import java.util.LinkedHashMap;

public class LRUCache<k, v> extends LinkedHashMap<k, v>{

    int capacity;
    public LRUCache(int capacity){
        super(capacity, 0.75f, true);//capacity, load factor, accessOrder
        this.capacity = capacity;
    }
    public boolean removeEldestEntry(){
        return size() > capacity;
    }
    public static void main(String args[]){
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(1, "Manas");
        cache.put(2, "ABC");
        cache.put(3, "XYZ");
        cache.put(4, "OPQ");

        //put and get methods affect the order of the entries.
        /*
        so here in this case till third inserti0on the doubly linked list will look like:
        Manas -> ABC -> XYZ and after fourth insertion the size of the map will be greater then the capacity and hance the least used once will be deleted. LinkedHashMap is implemented in such a way that when accessOrder is true then the least used once are in the front and recently used once are in the last.

        */
    }
}
