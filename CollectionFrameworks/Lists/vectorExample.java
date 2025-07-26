package CollectionFrameworks.Lists;

public class vectorExample {
    public static void main(String args[]){
        /*
        Vector are just like ArrayList only that increases their size automatically when more elements are added.

        Important -> Vectors support automatic synchronization that is using vectors are thread safe in a multithreaded environment.

        Due to its synchronized vectors are slow in processing.

        Hence in a single threaded environment its recommended to use ArraysList and in multithreaded enviornments vector is preferred.
        */

        /*

        contructors:
        Vector<Integer> vector = new Vector<Integer>(); -> creates a list with initial capacity as default one that is 10.

        Vector<Integer> vector = new Vector<Integer>(100); -> creates list with initial capacity as specified.

        //in vectors the capacity increases by double unlike ArrayList where it was increasing 1.5 times.

        Vector<Integer> vector = new Vector<Integer>(15, 2.5) -> here first arguement is the initial capacity and the second one is the increament you want when gets fulled. Here incase of custom increament value the capacity gets added. 
        */

        /*
        Some more vector methods:

        size() -> returns how many elements are currently stored

        isEmpty() -> returns a boolean that is a vector is empty or not

        contains(object o) -> check if the object with specified value is present or not

        clear() -> removes all the elements from the vector



        */
    }
}
