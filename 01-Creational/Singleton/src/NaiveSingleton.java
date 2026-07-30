public class NaiveSingleton {
 
    private static NaiveSingleton instance;


    private NaiveSingleton(){

        System.out.println("NaiveSingleton instance created!");
    }


    public static NaiveSingleton getInstance(){
        if (instance == null){
            instance = new NaiveSingleton();
        }
        return instance;
    }

    // Testing the failure

    public static void main(String[]args){
        Runnable task = () -> {
            NaiveSingleton obj = NaiveSingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + " -> " + obj.hashCode());
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        Thread t3 = new Thread(task, "Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }

}
