package CollectionFrameworks;
import java.util.*;
public class IdentityHashmapExample {
    public static void main(String args[]){
        //first lets take a scenerio with normal HashMap
        String key1 = new String("Key1");
        String key2 = new String("Key1");
        //both the strings are differnet objects as created using new keyword but have same value

        HashMap<String, Integer> map = new HashMap<>();
        map.put(key1, 1);
        map.put(key2, 2);
        //now lets see the above case here its the normal hashmap so in this case when we first inserted key1 it got inserted no problem but lets study what happens after second insertion.

        //we know here the keys are of string types so the hashcode method will be used is of String class which is implemented on the basis of content of the String and hence both the keys here will have same hashcode. So lets say after first insertion the first key-value pari goes in bucket index 1 then after the second insertion also the second key-value pair will try to go in bucket index 1 only because of same hashcodes.

        //now in this case of collision equality of the keys will checked using equals method and if true then replace the value if false then append in the linked list.

        //now in the case of strings the equals method will also be of String class which is based on content inside string object and hence it will return true.
        
        //and resultingly the calue will be replaced and map will have only one entry.

        System.out.println(map.size());


        //Now we will do the same case on Identity Hashmap:

        String keyObj1 = new String("key1");
        String keyObj2 = new String("key1");
        //both are different objects as created using new operator.

        IdentityHashMap<String, Integer> Imap = new IdentityHashMap<>();
        Imap.put(keyObj1, 1);
        Imap.put(keyObj2, 2);
        System.out.println(Imap.size());//here the size will come as 2 becasue these both will be independent entries and will not be replaced.

        //Reason:
        /*
        Above in the hashmap the hashcode and equals method are being used of String class but in the IdentityHashMap the hashcode method is used of Object class which is based on the memory address of the Object class and the equals method is used as == which hchecks the equality based on the memory address of objects.

        so here as both the keys are created using new operator it means different objects even with the same value now there are two cases:

        1) hashcodes are different :

        as both are independent objects and hashcode method is also of Object class based on memory address it can happen that hashcodes came to be different in that case there would be no arguement and the keys will be placed in different buckets.

        2) hahcodes came to be same:

        since hashcodes are limited it can happen that even after different Objects hashcodes can come same in that case equality will be checked using == which checks on the basisi of memory address and it will come to be different and hence the key will be appended in the linked list.

        NOTE on collision handling in IdentityHashMap:
        ----------------------------------------------
        - IdentityHashMap does NOT use buckets and linked lists like HashMap.
        - It uses a flat array and stores keys and values in alternating slots.
        - If two keys have the same identity hash code, it uses **linear probing** (open addressing) to find the next available slot.
        */

    }
}
