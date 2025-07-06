package multithreading;

// Deadlock -> Thread having pen is waiting for paper and thread having paper is waiting for pen
class pen {

    paper obj;

    public void setter(paper ref) {
        obj = ref;
    }

    public synchronized void writingWithPen() {
        System.out.println(Thread.currentThread().getName() + " is having pen and demanding for paper.");
        obj.writingwithPaper();
    }
}

class paper {

    pen obj;

    public void setter(pen ref) {
        obj = ref;
    }

    public synchronized void writingwithPaper() {
        System.out.println(Thread.currentThread().getName() + " is having paper and demanding for pen.");
        obj.writingWithPen();
    }
}

public class CreatingDeadlock {

    public static void main(String args[]) {
        paper paperObject = new paper();
        pen penObject = new pen();
        penObject.setter(paperObject);
        paperObject.setter(penObject);
        Runnable havingPaper = new Runnable() {
            public void run() {
                paperObject.writingwithPaper();
            }
        };
        Runnable havingPen = new Runnable() {
            public void run() {
                penObject.writingWithPen();
            }
        };
        Thread t1 = new Thread(havingPaper, "Paper");
        Thread t2 = new Thread(havingPen, "Pen");
        t1.start();
        t2.start();
    }
}
