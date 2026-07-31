public class LazySingleton {
    

    private static volatile LazySingleton instance;

    private LazySingleton(){
        System.out.println("LazySingleton instance created!");
    }

    public static LazySingleton getInstance(){
        if (instance == null){
            synchronized (LazySingleton.class){
                if (instance == null){
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
    public void showMessage(){
        System.out.println("Hello from LazySingleton! Hash:" + this.hashCode());
    }

    public static void main(String[]args){
        Runnable task = () ->{
            LazySingleton obj = LazySingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + " -> " + obj.hashCode());
        };

        Thread t1 = new Thread(task, "Thread-A");
        Thread t2 = new Thread(task, "Thread-B");
        Thread t3 = new Thread(task, "Thread-C");

        t1.start();
        t2.start();
        t3.start();

        try{
            Thread.sleep(500);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
