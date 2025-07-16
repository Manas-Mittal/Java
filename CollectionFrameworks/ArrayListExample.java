package CollectionFrameworks;

import java.util.*;

public class ArrayListExample {
    public static void main(String args[]){
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

        for(int i=0;i<myarr.size();i++){
            System.out.println(myarr.get(i));
        }
        //using for-each loop
        for(Integer val: myarr){
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


        */
    }
}
