package CollectionFrameworks;

public class CopyOnWriteArrayListExample {
    public static void main(String args[]){
        /*

        we know that LinkedList and ArrayList are not thread safe and concurrent access on these data structures can result to data inconsistency.

        we had a solution with us that are vector and stack that were thread safe and works weell in a multithreaded environment but then also there is a locking and unlocking mechanism that is being performed here which creates performance issues and for that CopyOnWriteArrayList is a solution.

        Here what happens is when there is a write operation that is to be performed on a CopyOnWriteArrayList then what will happen is a new copy of this list will be created and modifications will be done on that and then then reference of old list will get updated with the new one so by doing this readers that were reading on list will not get affected by modification and now the next reads will be according to the modified list.

        we use CopyOnWriteArrayList only when we have more read operations and less wirte operations becasue on every write operation there is a lot of memory consumption.

        
        */
    }
}
