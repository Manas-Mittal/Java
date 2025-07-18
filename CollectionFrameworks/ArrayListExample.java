package CollectionFrameworks;

import java.util.*;

public class ArrayListExample {

    public static void main(String args[]) {
        //ArrayList is class implementing List interface and we use ArrayList where we are not sure how many elements we have to store and hence it dynamically increase its size when it gets full, we can also store duplicate elements in it as well as the elements will be stored in a sequential order and will be accessed using indexes.
        ArrayList<Integer> myarr = new ArrayList<>();
        //we can also do:
        //List<Integer> myarr = new ArrayList<>(); because List is the parent hance its reference typace can hold object of subtype.

        //add:
        myarr.add(1);
        myarr.add(2);
        myarr.add(5);
        //get:
        System.out.println(myarr.get(0));

        for (int i = 0; i < myarr.size(); i++) {
            System.out.println(myarr.get(i));
        }
        //using for-each loop
        for (Integer val : myarr) {
            System.out.println(val.intValue());
        }
        //contains:
        System.out.println(myarr.contains(4)); //false

        //remove:
        myarr.remove(2);//removes item at 2nd index

        //add in between:
        myarr.add(1, 50);//adding at which index is the first arg. and what should be the element is the second arg, the element which was on 1st index will get shifted 1 to right.

        //set: for replacing the value at some index.
        myarr.set(0, 90);//replacing the value at index 0 with 90.

        //internal working of ArrayList:
        /*

        internally arrays are used to store data inside arraylist but the mecahnism is the default capacity when we create an arraylist is 10 and then as the values surpasses the capacity, at that time a new array of 1.5 times of size is created and the values of the old array are copied inside it.
        
        //Size of the Arraylist is the the number of elements it is holding and capacity is the number of elemnets the internal array can hold.

        // we have seen that when the elements surpasses the internal capacity then the resizing of the internal array happens and the elements from old internal array are copied into new one but we can definitely see it as a overhead as copying elements will also take O(n) time hence if we are sure that upto these numbers of elements we dont need resizing then we can do:
        ArrayList<Integer> list = new ArrayList<>(1000); here 1000 specifies the initial capacity that is the size of the internal array of this ArrayList.
         */
        // Arrays.asList() method explanation:

        /*
In the java.util.Arrays class, there is a private static inner class named ArrayList. 
⚠️ This class is NOT the same as java.util.ArrayList from the Collections framework.

Class declaration:
    private static class ArrayList<E> extends AbstractList<E> implements List<E>

This Arrays$ArrayList:
- Implements the List interface
- Inherits from AbstractList
- Overrides only the `get()` and `set()` methods
- Does NOT override `add()` or `remove()`

👉 Doubt: If it implements List, how can it not implement add() and remove()?
→ Because it inherits them from AbstractList.
   However, AbstractList's default implementation of `add()` and `remove()` 
   throws `UnsupportedOperationException`.

✅ So, if we call `add()` or `remove()` on the object returned by Arrays.asList(),
   the inherited methods from AbstractList will be executed,
   which throw an exception.

✅ On the other hand, java.util.ArrayList (the real one) properly overrides
   `add()`, `remove()`, and all necessary methods — so they work without error.

📌 Summary:
Arrays.asList() takes an array and wraps it with a fixed-size list 
(backed by that array) using Arrays$ArrayList — which allows only 
`get()` and `set()`. It does NOT support resizing operations like `add()` or `remove()`.

This class is completely different from the dynamic, resizable java.util.ArrayList.
         */
        List<String> stringList = Arrays.asList("orange", "mango", "pineapple");
// Returns an instance of Arrays$ArrayList, which behaves like a fixed-size list

//We can also do List<Integer> list = List.of(1, 2, 3, 4); this also returns an unmodifieable list but the difference from asList is here we cant even do replacing using set method.

        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        List<Integer> b = new ArrayList<>();
        b.add(5);
        b.add(6);
        b.add(7);
        b.add(8);
        a.addAll(b); //this will make a -> 1, 2, 3, 4, 5, 6, 7, 8

        //Interesting thing about remove method();
        /*
        declaration: public boolean remove(Object obj){}

        1. it returns true if element found and removed else it returns false and does nothing to the list.

        2. remove method is an overloaded method which removes on the basis of index and value both.

        3. if you pass a primitive value it will remove element on that index and if you pass object it will remove on the basis of the value.

        4. Eg: List<Integer> list = new ArrayList<>();
               list.add(1);
               list.add(2);
               list.add(3);
               list.add(4); 
               
               list.remove(1); //remove the element on 1st index 
               list.remove(Integer.valueOf(1)); //this is object hence it will remove the object with value 1 from the list.

        */

        /*
        For sorting a list we have two ways:

        Collections.sort(list object) -> uses default compareTo method of Objects present inside list this method is declared under Comparable interface and hence its necessary that is you are calling sort on a list then the Objects present inside the list should definitely implement comparable otherwise ClassCastException will come.


        list.sort(null) -> uses default compareto method for sorting the list


        list.sort(Comparator Object) -> Comparator is an interface that has a method compare its used to define our own sorting logic.

        if you do :

        Collections.sort(list, Comparator obj) -> then java will give preference to comparator.

        Note: A class can override only one compareTo() method, which means you get only one fixed/default sorting logic using Comparable.
        
        But in real-world projects, you often need to sort the same object in multiple different ways — for example, a Student might need to be sorted by ID, name, marks, or age.
        
        In such cases, I use Comparator because it lets me create as many different sorting strategies as I want without changing the original class or touching legacy code.

        Eg: 

        Comparator<Student> byName = (a, b) -> a.name.compareTo(b.name); //one type of sorting technique
        Comparator<Student> byMarks = (a, b) -> b.marks - a.marks; //another one

        use whichever you want list.sort(byName) or list.sort(byMarks)


        "If we are sure that the objects in the list will always be sorted in the same way, and we don’t need to change the sorting technique frequently, then it's better to use Comparable."
        */

    }



}