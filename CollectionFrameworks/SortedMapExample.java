package CollectionFrameworks;

import java.util.*;

public class SortedMapExample {
    public static void main(String args[]){
        //sorted map is an interface and some of the classes like TreeMap are its implementation.

        //The order of implementation is :
        // SortedMap(interface) -> NavigableMap(interface) -> Treemap(class)

        //sorted map says that the entries will be sorted based on the keys according to the comparator object given by you or if not then the Comparable will be used based on your key.
        //Eg: lets say i will insert <String, Integer> in the map in that case if i will give comparator then the keys will be sorted based on it and if not then String class implements Comparable interface and keys will be sorted based on compareTo() method.

        SortedMap<String, Integer> map = new TreeMap<>();
        map.put("Manas", 91);
        map.put("ABC", 10);
        map.put("XYZ", 89);
        //here in the above example we have not passed any comparator object in the constructor of our map and hence it will use the inbuilt comapareTo method from String class that came from Comparable interface to sort the entries on the basis of the keys.

        System.out.println(map); //output will be ("ABC", 10), ("Manas", 91), ("XYZ", 89);

        //Interesting: SortedMap extends Map and hence we can do that reference is of Map and object is of TreeMap type then whats the need of the SortedMap interface?
        // -> SortedMap provides some very interesting methods to use on sorted entries some of them are :
        
        System.out.println(map.firstEntry()); //will return the first entry
        System.out.println(map.lastEntry()); //will return the last entry
        System.out.println(map.firstKey()); //will return the first key
        System.out.println(map.lastKey());//will return the last key
        System.out.println(map.headMap("Z")); //it will give the data from starting to this value.
        System.out.println(map.tailMap("C")); //it will give data from this key till end

        //giving comparator object inside constructor:

        SortedMap<Integer, String> map1 = new TreeMap<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b){
                return Integer.compare(a, b);
            }
        });

        //treemap stores the data as a red black tree so the time complexity of put and get calls is O(logn) which was O(1) in normal hashmap.

        //NavigableMap:

        NavigableMap<Integer, String> nmap = new TreeMap<>();
        nmap.put(5, "Five");
        nmap.put(3, "three");
        nmap.put(1, "one");
        //Some extra functionalities of NavigationMap are:
        System.out.println(nmap.lowerEntry(5)); //return entry corresponding to hte key that is greater than all others but smaller then 5

        System.out.println(nmap.ceilingEntry(1));//returns smaller then all but greater then or equal to 1.

        System.out.println(nmap.lowerKey(4));
        System.out.println(nmap.ceilingKey(1));

        System.out.println(nmap.descendingMap());//reverses the order of the map
    }
}

/* Most Important:

we know the hierarchy is:

Map -> SortedMap -> NavigableMap -> TreeMap

we can use any of the reference type till NavigableMap and we can create actual object of TreeMap but the main point is which reference type to use when.

Map -> when you only want basic map operations like put, get and remove and no other speciality with sorted data. The keys will be in the sorted order but due to lack of operations on sorted data it will be of no use.

SortedMap -> You dont need navigation functionalities, you only need firstKey, lastKey and this type of operations.

NavigableMap -> when you want Map features + SortedMap + NavigableMap features like lowerKey, ceilingKey and many more.

Using TreeMap as reference type will make you lose flexibility of changing the object type and use Dynamic Method Dispatch.


*/
