public class EagerSingleton {
    

    private static final EagerSingleton INSTANCE = new EagerSingleton();

    private EagerSingleton(){
        System.out.println("EagerSingleton instance created!");
    }

    public static EagerSingleton getInstance(){
        return INSTANCE;
    }

    public void showMessage(){
        System.out.println("Hello from EagerSingleton! Hash: " + this.hashCode());
    }

    public static void main(String[]args){

        EagerSingleton obj1 = EagerSingleton.getInstance();
        EagerSingleton obj2 = EagerSingleton.getInstance();
        System.out.println("obj1 has:" + obj1.hashCode());
        System.out.println("obj2 hash: " + obj2.hashCode());
        System.out.println("Are they equal?" + (obj1 == obj2));
    }
}
