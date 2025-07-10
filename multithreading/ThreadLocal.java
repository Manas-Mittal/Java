package multithreading;

public class ThreadLocal {
    public static void main(String args[]){
        /*

        Thread local class provides thread local variables .

        Thread Local class maintains values per thread basis.

        Each thread local object maintains a separate value like userID, transactionID, etc. For each thread that accesses that object.

        Thread can access its local value, can manipulate its value and even can remove its value.

        In every part of the code which is executed by the thread we can access its local variable.

        Note:
        1. ThreadLocal class introduced in 1.2 version and enhanced in 1.5 version.
        2. Thread local can be associated with thread scope.
        3. total code which is executed by thread has access to the corresponding thread local variables.
        4. A thread can access its own local variables and cant access other threads local variables.
        5. Once thread entered into dead state all its local variables are by default available for garbage collection.
        */
        //Constructor:
        // ThreadLocal tl = new ThreadLocal(); creates a thread local variable.
        
        //Methods:
        
        /*
        Object get() -> returns the valueof thread local variable associated with current thread.

        Object initialValue() -> returns initial value og thread local variable associated with current thread. The default implementation of this method returns NULL to customize our own initial value we have to override this method.

        void set(Object newValue) -> to set a new value.

        void remove() -> to remove the thread local variable associated with current thread.

        









        */
    }
}
