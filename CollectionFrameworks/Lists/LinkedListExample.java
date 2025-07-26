package CollectionFrameworks.Lists;
import java.util.*;
public class LinkedListExample {
    public static void main(String args[]){
        //LinkedList that is already implemented in java is a doubly linked list that is every node contains data, reference of next node and reference of previous node.
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.get(2); // get the element at second position.
        //in arraylist get method takes O(1) time becasue arraylist works on indexes but incase Linked List get method takes O(n) time because it needs to traverse the lsit from start.
        linkedList.add(2, 5); //add 5 on second index
        linkedList.addLast(5); //add to tail
        linkedList.addFirst(6); //make new head
        System.out.println(linkedList);
        linkedList.getLast(); //returns the last element or the tail element.
        linkedList.set(2, 10); //replace value at 2nd index with 10
        /*

        remove from linked list:

        remove(Object) -> searches for the given and delete

        remove(index) -> goes at the index and delete, here also index starts with 0.

        removeFirst() -> removes the current head element

        removeLast() -> remove the last element

        removeFirstOccurrence(Object) -> removes first occurrence of the given value

        removeLastOccurrence(Object) -> removes last occurrence of the given value
        */
        
        //creating LinkedList using asList method:
        LinkedList<String> animalList = new LinkedList<>(Arrays.asList("Cat", "dog", "cow", "elephant"));
        //we can only use set and get method on this list and we cannot modify this list as its a fixed size list.
    }
}
