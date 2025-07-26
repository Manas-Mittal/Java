package CollectionFrameworks;

import java.util.*;

public class iteratorExample {

    public static void main(String args[]) {
        //the top most interface which acts as a parent interaface for all collection classes and interfaces is Iterable a class that implements iterable can only be iterated using for-each loop or using an iterator object.

        //iterator:
        /*
        normal access using indexed has some of the drawbacks that are:

        1. you cant do modifications while accessing the elements it will throw a ConcurrentModificationException but iterator lets you do that.

        2. not every collection uses an indexes to store and hence to iterate over those we indeed need an iterator
         */
        //Example code:
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Iterator<Integer> it = list.iterator();
        while (!it.hasNext()) {
            Integer val = it.next();
            System.out.println(val.intValue());
        }
        // Working of Iterators:
        /*
    When we call `list.iterator()`, this returns an iterator object corresponding to that list.
    This iterator object maintains a few important internal fields:

    1. cursor → Initially at index 0. It tracks the position of the next element to return.

    2. expectedModCount → A copy of the list’s internal modCount at the time the iterator was created.
    It is used to detect any structural modification made to the list outside the iterator.

    What happens during iteration:

    - When we call `it.next()`, it returns the element at the current cursor position, then increments the cursor (i.e., cursor++).

    How iterators detect unsafe modifications:

    - The list (e.g., `ArrayList`) maintains a field called `modCount`, which increments every time a structural change happens (e.g., add/remove).

    - The iterator stores the `expectedModCount`, which should stay in sync with the list's `modCount`.

    - If during iteration we modify the list directly using `list.add()` or `list.remove()`, the list’s `modCount` changes, but the iterator's `expectedModCount` remains unchanged.

    - On the next call to `it.next()` or `it.remove()`, the iterator checks:
        if (modCount != expectedModCount)
        → then it throws a ConcurrentModificationException.

    Safe modification:

    - If we remove elements using `it.remove()` (after calling `next()`), then the iterator updates its `expectedModCount` to match the list’s `modCount`, so no exception is thrown.

    Note: The basic `Iterator` interface does not support `it.add()` — only `remove()`. For adding elements during iteration, we use `ListIterator`, ListIterator contains it.add method but normal iterator doesnt.
            */
                //Special case regarding iterators:
                /*

        iterators incase of maps:

        First we will understand about map, Entry interface, entrySet:

        map is a collection that stores the data in the form of key-value pairs.

        map interface has an inner interface called: 
        Entry<k, v>{
            k getKey();
            v getValue();
        }
        each entry in map (key-value pair) is a reference of this Entry interface for eg:
        A->10 (an object which is referenced by Entry type variable and using this object we can retirieve the key and the value)
        
        entrySet() -> this is a method in map interface that returns a set containng all the Entry type of objects that are stored inside map for eg:

        A->10 (Entry obj1)
        B->20 (Entry obj2)
        C->30 (Entry obj3)
        D->40 (Entry obj4)
        E->50 (Entry obj5)

        so map.entrySet() will return a set of these Entry objects i.e. [obj1, obj2, obj3, obj4, obj5];

        so we always create an iterator over this set and not on the map directly:

        Set<Map.Entry<String, Integer>> st = map.entrySet(); returned a set and then

        Iterator<Map.Entry<String, Integer>> it = st.iterator(); returned iterator to iterate over entry objects.

        and we combine both steps and write:
        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        and,
        it.next() method always takes out current Entry object from entrySet and returns that to you.
                 */
    }
}
