public class WithoutBuilder {
    
    private String name; // Required Field
    private int age;   // And also this is Required Filed
    private String phone; // Optional Field
    private String address; // Optional Field

    // Constructor 1: Only required
    public WithoutBuilder(String name){
        this(name, 0);
    }

    // Constructor 2: Name + Age
    public WithoutBuilder(String name, int age){
        this(name, age, null);
    }
    // Constructor 3: Name + Age + Phone

    public WithoutBuilder(String name, int age, String phone){
        this(name, age, phone, null);
    }

    // Constructor 4: Everything (The "King" constructor)
    public WithoutBuilder(String name, int age, String phone, String address){
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.address = address;
    }

    // Getters and toString()
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }
    
    @Override
    public String toString(){
        return "WithoutBuilder{" +
                "name='" + name +'\''+
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", address='" + address +'\'' +
                '}';
    }

    // Testing the Naive way
    public static void main(String[]args){
        // PROBLEM 1: What does 'null' mean here? Address? Phone?
        WithoutBuilder user1 = new WithoutBuilder("Alice", 30, null, "123 Main St");

        //PROBLEM 2: Imagine this was a large codebase.
        // If you swap the order by accident (String, int, String, String) -> Good luck debugging
        System.out.println(user1);
    }
}
