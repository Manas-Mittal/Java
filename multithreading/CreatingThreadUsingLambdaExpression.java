package multithreading;

public class CreatingThreadUsingLambdaExpression {
    public static void main(String args[]){
        //Runnable is functional interface that is this type of interface only contains one abstract method and hence we can create an anonymous class that is a class which can be instantiated only once and inside the body we can directly write the implementation of the abstract method. 
        Runnable obj = () -> {
            System.out.println(Thread.currentThread().getName()+" is a Thread created using Lambda Expression");
        };
        Thread t1 = new Thread(obj, "LambdaThread");
        t1.start();
    }
}
