package CollectionFrameworks;
import java.util.*;
public class unmodifiableSet {
    public static void main(String args[]){
        //we can use Set.of() method but heres a twist here we can store more then 10 entries also using this method but in map we are not allowed to store more then 10 entries using Map.of.

        //or we can use Collections.unmodifiableSet method which takes the refernce of a Set in the constructor and returns the refernece of an unmodifiable Set.
        Set<Integer> st1 = new HashSet<>();
        st1.add(1);
        st1.add(2);
        st1.add(3);
        //above st1 is a modifiable set.

        Set<Integer> unmodifiable = Collections.unmodifiableSet(st1);//new set is created using st1 which is immutable and its refernced is returned inside unmodifiable.

        //using Set.of()

        Set<Integer> st2 = Set.of(1, 2, 3, 4, 5, 6);
    }
}
