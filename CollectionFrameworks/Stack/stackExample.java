package CollectionFrameworks.Stack;
import java.util.*;
public class stackExample {
    public static void main(String args[]){
        // stack extends vector class hence stack is also thread safe
        Stack<Integer> st = new Stack<>();
        st.push(1); //adding to stack
        st.push(2);
        Integer removedTopElement = st.pop(); //fetches the top element in LIFO order and remove it.
        Integer peekElement = st.peek(); //just see whats on the top and dont remove it.
        st.push(5);
        st.push(6);
        st.push(7);
        //as stack in java extends vector class hence we can also use it as simple list and the indexing starts from 0 from bottom to top.

        st.add(1, 10);//add 1 at 1st index from bottom.

        st.get(3); //getting item at 3rd index from bottom

        //stack using ArrayList:
        ArrayList<Integer> ArrayListAsStack = new ArrayList<>();
        ArrayListAsStack.add(1);
        ArrayListAsStack.add(2);
        ArrayListAsStack.add(3);
        ArrayListAsStack.get(ArrayListAsStack.size()-1); //peek as we are only getting the top element and not removing it.
        ArrayListAsStack.remove(ArrayListAsStack.size()-1);// removing the top element just like pop.

    }
}
