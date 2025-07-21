package CollectionFrameworks;

import java.util.*;

public class HashMapExample {

    public static void main(String args[]) {
        //hashmap soesnt stores the pairs in any order it can be random.
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Manas"); //to insert a key value pair in map.
        map.put(2, "abc");
        map.put(3, "xyz");
        map.get(3); //getting value using key
        map.containsKey(45); //is this key present in the map or not

        map.containsValue("Manas"); //to find out specified value is present in the map as value or not
        Set<Integer> keys = map.keySet(); //it returns a set of all keys in the map.

        for (Integer k : keys) {
            System.out.println(k);
        }
        Set<Map.Entry<Integer, String>> entries = map.entrySet(); //to iterate over a map

        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        //to convert every value to upper case:
        for (Map.Entry<Integer, String> entry : entries) {
            entry.setValue(entry.getValue().toUpperCase());
        }
        //O(1) time complexity for get and put methods.


// Internal working of a HashMap in Java

/*
- HashMap internally uses an array of size 16 by default, known as the **bucket array**.
- Each index of this bucket array can hold multiple key-value pairs, usually using a **linked list** initially.

- When we insert a key-value pair into the HashMap:
   1. The key object is passed through a **hash function**, which returns a 32-bit integer called the **hash code**.
   2. Since hash codes are finite (2^32 possibilities), it's possible for **two different keys to have the same hash code** — this is called a **hash collision**.
   3. The hash code is then used to calculate an **index in the bucket array** using the formula:  
      `(n - 1) & hash`, where `n` is the length of the array. (Internally, it's not just `hash % 16` for performance reasons.)
   4. If two keys result in the same index, they're **stored in a linked list** at that index.

- If the number of elements (nodes) in a single bucket exceeds **8**, and the total number of buckets is more than 64, then the linked list is converted into a **Red-Black Tree**.  
  This process is known as **treeification**, which helps improve search performance in case of high collisions.
         */
// Retrieval in HashMap

        /*
- When you do map.get(key):
   1. HashMap computes the hash code of the key and then calculates the bucket index.
   2. It then checks that bucket.
   3. If a **linked list or tree** is present, it searches for the **correct key** using `equals()`, and returns the associated value.
         */
// Rehashing in HashMap

        /*
- HashMap has a **load factor** (default is 0.75), which means:
   - When the number of key-value pairs exceeds `capacity × load factor`, the HashMap resizes (rehashing).
   - The internal array size is **doubled**, and **all existing entries are re-inserted** into the new array.
   - Rehashing is needed because the bucket index depends on array length, so indexes must be recomputed.
         */


         //explicitly specifying initial capacity and load factor

         HashMap<Integer, String> map2 = new HashMap<>(20, 0.5f);// here the internal bucket array will be of size 20 initially rather then 16 and the laod factor is 50 % that is when 50% of bucket aray will get filled then the bucket array size will get doubled.


// Contract between equals() and hashCode() in HashMap

/*
1) Only equals() is implemented but not hashCode():

    - Two different key objects may return true for equals().
    - But if hashCode() is not overridden, default hashCodes from Object class will be used.
    - These default hashCodes are usually different, so both keys will be placed in different bucket indexes.
    - This violates HashMap rule: two equal keys should not exist in the map.
    - So, duplicate key-value pairs can be inserted, which breaks the logic.
*/


/*
2) Only hashCode() is implemented but not equals():

    - Two different key objects may return same hashCode(), hence same bucket index.
    - But equals() is not overridden, so it will use Object class's equals() which checks reference equality.
    - So even if keys are logically equal, equals() will return false.
    - During retrieval, map.get(key) will fail to find the correct key in the linked list/tree at that bucket index.
    - Hence, retrieval fails.
*/


/*
✅ Conclusion:

    - Always override both hashCode() and equals() if you're using objects as keys in HashMap.
    - Follow the contract:
        - If two objects are equal according to equals(), they must return same hashCode().
        - If hashCodes are same, equals() is used to resolve actual key match in the bucket.
*/
    }
}
