package multithreading;

import java.util.concurrent.Semaphore;

class printing {

    Semaphore semNumber = new Semaphore(1);
    Semaphore semFizz = new Semaphore(0);
    Semaphore semBuzz = new Semaphore(0);
    Semaphore semFizzBuzz = new Semaphore(0);
    int currentIteration = 1;
    int total;

    public printing(int n) {
        total = n;
    }

    public void printNumber() {
        while (currentIteration <= total) {
            try {
                semNumber.acquire();
            } catch (Exception e) {

            }

            if (currentIteration % 3 != 0 && currentIteration % 5 != 0) {
                System.out.print(currentIteration);
                currentIteration++;
                semNumber.release();
            } else if (currentIteration % 3 == 0 && currentIteration % 5 != 0) {
                semFizz.release();
            } else if (currentIteration % 3 != 0 && currentIteration % 5 == 0) {
                semBuzz.release();
            } else {
                semFizzBuzz.release();
            }
        }
    }

    public void printFizz() {
        while (currentIteration <= total) {
            try {
                semFizz.acquire();
            } catch (Exception e) {

            }
            System.out.print("fizz");
            currentIteration++;
            semNumber.release();
        }
    }

    public void printBuzz() {
        while (currentIteration <= total) {
            try {
                semBuzz.acquire();
            } catch (Exception e) {

            }
            System.out.print("buzz");
            currentIteration++;
            semNumber.release();
        }
    }

    public void printFizzBuzz() {
        while (currentIteration <= total) {
            try {
                semFizzBuzz.acquire();
            } catch (Exception e) {

            }
            System.out.print("fizzbuzz");
            currentIteration++;
            semNumber.release();
        }
    }
}

class number extends Thread {

    printing obj;

    public number(printing ref) {
        obj = ref;
    }

    public void run() {
        obj.printNumber();
    }
}

class fizz extends Thread {

    printing obj;

    public fizz(printing ref) {
        obj = ref;
    }

    public void run() {
        obj.printFizz();
    }
}

class buzz extends Thread {

    printing obj;

    public buzz(printing ref) {
        obj = ref;
    }

    public void run() {
        obj.printBuzz();
    }
}

class fizzbuzz extends Thread {

    printing obj;

    public fizzbuzz(printing ref) {
        obj = ref;
    }

    public void run() {
        obj.printFizzBuzz();
    }
}

public class fizzBuzzProblem {

    public static void main(String args[]) {
        printing obj = new printing(8);
        number t1 = new number(obj);
        fizz t2 = new fizz(obj);
        buzz t3 = new buzz(obj);
        fizzbuzz t4 = new fizzbuzz(obj);
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
