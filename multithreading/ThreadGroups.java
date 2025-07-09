package multithreading;

class MyThread extends Thread {

    public MyThread(ThreadGroup g, String name) {
        super(g, name);
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running.");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }
    }
}

public class ThreadGroups {

    public static void main(String args[]) {
        //we can create groups of threads based on their functionalities which will make easy for us to perform any common types of operations on any thread. For eg: we can make all producer threads at once or we can join all consumer thread at once.

        //Thread groups can also contain subgroups inside them. 
        //in java every thread belongs to some group for eg main thread belons to main group.
        //System group acts as a parent for every thread or thread group in java.
        System.out.println(Thread.currentThread().getThreadGroup().getName());// printing group name of main thread -> main group

        System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());//printing group which is parent for main group -> system group

        //system group contains various child threads and child thread groups for eg:
        //Finalizer thread: GC
        //Attach Listener
        //Reference Handler
        //Signal Dispatcher
        //Main thread group
        //ThreadGroup is a java class which is a direct child of Object class
        //Constructors: ThreadGroup(String groupName)
        ThreadGroup g1 = new ThreadGroup("First Group"); //this group "First Group" is created as a subgroup inside main group beacause main thread executed this line.

        //if i want to specify that this group should be child subgroup of my specified group and not the default one: 
        //ThreadGroup(ThreadGroup tg, String name) -> reference of parent tg and name of you group
        ThreadGroup g2 = new ThreadGroup(g1, "SubGroup");//so this group named SubGroup will be a child sub group of g1 as specified in constructor.

        //Some important methods of ThreadGroup class

        /*
        String getName() -> returns name of the current ThreadGroup

        int getMaxPriority() -> returns max priority of thread group
        
        void setMaxPriority(int p) -> to set maximum priority of thread group, jab hum kisi group ki max priority set krte hain to automatically jo new threads us group mein add hongi agar unki priority max se kam hai then no problem but if greater unki priority automatically humare grp ki max priority ho jaegi.
        This law is not for existing threads agr koi thread with priority 4 is present in grp and you change grp max priority to 3 then also existing thread ki priority 4 hi rhegi.
         */
        Thread t1 = new Thread(g1, "FirstThread");//new thread FirstThread in grp referenced by g1 group with default priority 5

        Thread t2 = new Thread(g1, "SecondThread");//another thread in referenced by g1 named SecondThread with default priority 5.

        g1.setMaxPriority(3);// max priority of group referenced by g1 is set to 3

        Thread t3 = new Thread(g1, "ThirdThread");// another thread in grp referecned by g1 named as ThirdThread with default priority 5

        System.out.println(t1.getPriority());//5 uneffected as its an existing thread
        System.out.println(t2.getPriority());//uneffected as it was an existing thread
        System.out.println(t3.getPriority());//tried to add with 5 but priority became 3 as groups max priority was set to 3 before adding this thread to group

        /*
        
        ThreadGroup getParent() -> returns reference of parent grp of current thread.

        void list() -> it prints information about thread group to the console.

        int activeCount() -> how many active counts present in the thread grp and in subgroups also

        int activeGroupCount() -> returns no. of active grps present in the current thread grp

        int enumerate(Thread t[]) -> copy all the active threads references to the array

        Thread t[] = new Thread[10];
        int count = g.enumerate(t); // copy references of all active threads of g grp inside the t thread array.

        it returns the number of threads copied.

        it only copies the active threads i.e. threads for which isAlive() is true.

        if the array t is too small then some threads wont be copied

        we can also do g.enumerate(t, boolean recurse), where if recurse is true it means copy threads from subgroups too.

        int enumerate(ThreadGroup g[]) -> to copy all active sub thread grps into thread grp array

        boolean isDaemon()-> thread grp is daemon or not

        void setDaemon(boolean b) -> set the thre4ad grp to daemon or reset it

        void interrupt() -> to interrupt all waiting or sleeping threads present in the thread grp
        
        void destry() -> to destry thread grp and its sub thread grps

         */
        //Demonstration of above methods:
        ThreadGroup pg = new ThreadGroup("ParentGroup");

        ThreadGroup cg = new ThreadGroup(pg, "ChildgGroup");
        MyThread thread1 = new MyThread(pg, "ChildThread1");

        MyThread thread2 = new MyThread(pg, "ChildThread2");

        thread1.start();
        thread2.start();

        System.out.println(pg.activeCount());//2, as two active threads are present in group referenced by pg

        System.out.println(pg.activeGroupCount());//1 -> no. of subgroups

        pg.list();
        //output by list method is the details of the ThreadGroup
        /*
        2
        Child Thread
        Child Thread
        1
        java.lang.ThreadGroup[name = ParentGroup, maxpri = 10]
        Thread[ChildThread1, 5, ParentGroup]
        Thread[ChildThread2, 5, ParentGroup]
        java.lang.ThreadGroup[name = ChildGroup, maxpri = 10];
         */

        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
        }
        System.out.println(pg.activeCount());//0, both the threads will be terminated when main thread was sleeping
        System.out.println(pg.activeGroupCount());//1, group will reamin as it is.
        pg.list();

        //Program to print all active threads names present in System grp and its child grps:
        ThreadGroup MainGrp = Thread.currentThread().getThreadGroup(); //main
        ThreadGroup SystemGrp = MainGrp.getParent();//system
        Thread t[] = new Thread[SystemGrp.activeCount()];
        SystemGrp.enumerate(t, true);
        for (Thread thread : t) {
            System.out.println(thread.getName());
        }

    }
}
