package CollectionFrameworks;

import java.util.*;

public class ImmutableMapExample {
    public static void main(String[] args) {
        //Immutable map is used when you want to create an unmodifiable view of a map:

        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(1, "one");
        hm.put(2, "two");
        hm.put(3, "three");
        hm.put(4, "four");
        //Currently this hashmap is modifiable but if i want that i need a view of this map such that no one can modify that view then:
        Map<Integer, String> unmodifiedMap = Collections.unmodifiableMap(hm);
        System.out.println(unmodifiedMap);
        unmodifiedMap.put(5, "five"); //this will give us Exception.

        //there is one more way by which we can directly create an immutableMap and that is using Map.of method and Map.ofEntries method, both creates an unmodifiableMap but the differnece is Map.of method creates the map that can only hold upto 10 entries and Map.ofEntries method creates a map with any number of entries.

        Map<Integer, String> map1 = Map.of(1, "one", 2, "Two", 3, "three"); //here map1 is an immutable map but can hold upto 10 entries only as created using of method
        Map<Integer, String> map2 = Map.ofEntries(Map.entry(1, "one"), Map.entry(2, "Two"), Map.entry(3, "three"), Map.entry(4, "four")); //map2 is also an immutable map but can hold any number of entries.
    }
}
