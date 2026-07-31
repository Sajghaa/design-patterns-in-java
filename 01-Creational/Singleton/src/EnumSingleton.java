import java.rmi.server.ExportException;

public enum EnumSingleton {
    INSTANCE;

    private String value;

    public String getValue(){
        return value;
    }

    public void setValue(String value){
        this.value = value;
    }

    public void showMessage(){
        System.out.println("Hello from EnumSingleton! hash: " + this.hashCode());
    }

    public static void main(String[]args){
        EnumSingleton obj1 = EnumSingleton.INSTANCE;
        obj1.setValue("First value");

        EnumSingleton obj2 = EnumSingleton.INSTANCE;
        obj2.setValue("Second value");

        System.out.println("obj1 hash: " + obj1.hashCode());
        System.out.println("obj2 hash: " + obj2.hashCode());
        System.out.println("Are they the same?" + (obj1 == obj2));
        System.out.println("Value from obj1:" + obj1.getValue());

        try {
            java.lang.reflect.Constructor<EnumSingleton> constructor = EnumSingleton.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            EnumSingleton broken = constructor.newInstance();
            System.out.println("Reflection succeeded?" + broken);
        } catch (Exception e){
            System.out.println("Reflection attack failed: " +e.getMessage());
        }
    }
}