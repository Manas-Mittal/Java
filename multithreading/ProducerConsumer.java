package multithreading;

// ✅ SharedResource acts as a single-slot buffer for Producer and Consumer
class sharedResource {

    int data;               // Data to be shared between producer and consumer
    boolean hasData;        // true = buffer full, false = buffer empty

    // 👨‍🏭 Producer uploads data
    public synchronized void produce(int val) {
        while (hasData) {   // If buffer is full, wait until consumer consumes
            try {
                wait();     // 💤 Thread gives up lock and waits
            } catch (InterruptedException ex) {
                // Ignored for simplicity
            }
        }
        data = val;         // Put data into buffer
        hasData = true;     // Mark buffer as full
        System.out.println(Thread.currentThread().getName() + " has uploaded the data: " + data);
        notify();           // 🔔 Wake up consumer thread if waiting
    }

    // 👨‍💼 Consumer downloads data
    public synchronized void consume() {
        while (!hasData) {  // If buffer is empty, wait until producer produces
            try {
                wait();     // 💤 Thread gives up lock and waits
            } catch (InterruptedException e) {
                // Ignored for simplicity
            }
        }
        hasData = false;    // Mark buffer as empty
        System.out.println(Thread.currentThread().getName() + " has downloaded the data: " + data);
        notify();           // 🔔 Wake up producer thread if waiting
    }
}

// 👨‍🔧 Producer thread that generates data
class producer extends Thread {

    sharedResource obj;

    public producer(String name, sharedResource ref) {
        super(name);        // Set thread name (e.g., "Producer")
        obj = ref;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            obj.produce(i); // 🔁 Produce values 0 to 9
        }
    }
}

// 👨‍🎓 Consumer thread that processes data
class consumer extends Thread {

    sharedResource obj;

    public consumer(String name, sharedResource ref) {
        super(name);        // Set thread name (e.g., "Consumer")
        obj = ref;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            obj.consume();  // 🔁 Consume 10 values
        }
    }
}

// 🧵 Main class to start the producer-consumer system
public class ProducerConsumer {

    public static void main(String args[]) {
        sharedResource obj = new sharedResource(); // 📦 One shared buffer

        producer t1 = new producer("Producer", obj); // 👨‍🏭 Producer thread
        consumer t2 = new consumer("Consumer", obj); // 👨‍💼 Consumer thread

        t1.start();  // 🚀 Start producer
        t2.start();  // 🚀 Start consumer
    }
}
