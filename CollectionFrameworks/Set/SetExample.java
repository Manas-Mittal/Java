package CollectionFrameworks;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

public class SetExample {
    public static void main(String args[]){
        //Set is an interface just like Map and some of the implementing classes are : HashSet, LinkedHashSet, TreeSet.

        //internal implementation:
        //set uses hashmap internally to store the values as keys inside it because hashmap hasve a concept of unique keys.

        Set<Integer> st1 = new HashSet<>();
        st1.add(1);
        st1.add(2);
        st1.add(3);
        System.out.println(st1);//no ordering of value, randomly stored incase of HashSet

        Set<Integer> st2 = new LinkedHashSet<>();
        st2.add(1);
        st2.add(2);
        st2.add(3);
        System.out.println(st2); //insertion order is preserved.
        //LinkedHashSet internally stores the values as keys in LinkedHashMap and we know that LinkedHashMap uses doubly linked list to preserve the insertion order.

        //For sorted order we can use TreeSet.
        Set<Integer> SortedSt = new TreeSet<>();
        SortedSt.add(5);
        SortedSt.add(7);
        SortedSt.add(2);
        SortedSt.add(6);
        System.out.println(SortedSt); //here the set will contain values in sorted order and in this case the sorting is done using comparable(compareTo method of Integer class) as we hadnt passed any comparator object.

        Set<Integer> st3 = new TreeSet<>((a, b) -> {
            return Integer.compare(a, b);
        }); //sorting will be based on this implementation of compare method of Comparator interface.
        // and for this the heirarchy is Set -> SortedSet -> NavigabeleSet -> TreeSet
        //Hence incase of TreeSet we can use Set or SortedSet or NavigableSet as reference.
        //underlying data structure incase of TreeSet is red-black tree for sorting and hence the time complexity of all operations is O(logn).

        //For thread safety we have two options that are:

        //1) Collections.synchronizedSet method -> this returns a reference of a set which has all its methods wrapped under synchronized block and hence its thread safe, it takes a set of any type wither HashSet, LinkedHashSet or TreeSet inside constructor but the problem is it has performance issues as if one thread is performing some operations then others must wait even is they are readers.

        Set<Integer> concurrentSet = Collections.synchronizedSet(st2);
        //so in this case st2 is made concurrent set using synchronized set and the reference of this new set is inside concurrentSet variable.

        // NOTE: When iterating over a synchronized set, you must manually synchronize:
        synchronized (concurrentSet) {
            for (Integer val : concurrentSet) {
                // safe iteration
            }
        }

        // 2) ConcurrentSkipListSet:
        // This is a high-performance, thread-safe implementation of a NavigableSet.
        // It uses a skip list internally to provide log(n) time for most operations.
        // Unlike the synchronizedSet, it allows concurrent reads and (some) concurrent writes without locking the whole structure.
        // It is sorted (like TreeSet), so elements are maintained in natural order or with a custom comparator.

        ConcurrentSkipListSet<Integer> skipListSet = new ConcurrentSkipListSet<>();

        // Since ConcurrentSkipListSet implements Set and NavigableSet,
        // you can use either type as a reference:
        // Set<Integer> s1 = new ConcurrentSkipListSet<>();
        // NavigableSet<Integer> s2 = new ConcurrentSkipListSet<>();

    }

}
