package CollectionFrameworks.Lists;

import java.util.concurrent.CopyOnWriteArrayList; // Don't forget the import!

public class CopyOnWriteArrayListExample {
    public static void main(String args[]){
        /*

        Concurrent version of ArrayList.

        We know that LinkedList and ArrayList are not thread-safe. Concurrent access to these data structures from multiple threads can easily lead to data inconsistency and unexpected behavior (like ConcurrentModificationException during iteration).

        Older solutions like Vector and Stack provide thread-safety through a simple locking mechanism (their methods are 'synchronized'). While this makes them thread-safe, it often leads to performance bottlenecks and high contention, as only one thread can access the collection at a time, even for read operations.

        For scenarios where reads vastly outnumber writes, CopyOnWriteArrayList offers a more performant and scalable solution.

        Here's how CopyOnWriteArrayList achieves thread-safety:
        When a write operation (like add()) is performed on a CopyOnWriteArrayList:
        1. An **internal lock** is acquired (this serializes write operations, ensuring only one modification happens at a time).
        2. A **new, separate copy** of the entire underlying array is created.
        3. The modifications are performed on this **new copy**.
        4. Once the modifications are complete on the new copy, the **internal reference** of the list is atomically updated to point to this new array.

        By doing this, readers that are currently accessing the list (which are reading from the *old* array's reference) are **not affected** by the modification. They continue to read from the consistent, immutable old copy. Any subsequent read operations will then access the newly updated array. This strategy effectively makes **read operations non-blocking and highly concurrent**.

        We use CopyOnWriteArrayList primarily when:
        - We have **significantly more read operations than write operations**.
        - The list is **not excessively large** (as copying a large array consumes considerable memory and CPU time on every write).

        The main benefit is avoiding contention for readers, as they never need to acquire a lock.

        In the case of looping (iteration) on a CopyOnWriteArrayList:
        If you change the list while iterating over it (e.g., inside the loop):
        - In a normal `ArrayList` (when iterated using standard iterators), this would immediately result in a `ConcurrentModificationException`.
        - In `CopyOnWriteArrayList`, the iterator holds a reference to the **original array (the snapshot)** that existed when the iterator was created. Therefore, the loop continues to iterate over this old, consistent copy, and no exception occurs. The changes you make during the loop will be applied to a *new* copy of the list, and subsequent readers (or a new iterator) will see those changes. The currently running loop will **not** see the changes made while it's iterating.

        Common use cases include managing a list of event listeners, observers, or configuration lists that are updated infrequently but read very often.

        iterator of copyOnWriteArrayList cant perform remove or set operation because they will work on clones and data inconsistency can occy while merging.

        */
    }
}