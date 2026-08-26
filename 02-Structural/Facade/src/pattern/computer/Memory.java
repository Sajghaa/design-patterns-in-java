package pattern.computer;

public class Memory {
    public void load(long position, byte[] data){
        System.out.println("Memory: Loading data at " + position + "(Size: " + data.length +")");
     }
}
