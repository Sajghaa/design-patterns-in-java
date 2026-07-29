import java.lang.module.ModuleDescriptor.Builder;

public class WithBuilder {

    
    private final String name;
    private final int age;
    private final String phone;
    private final String address;

    // Private constructor: only the builder can call this
    private WithBuilder(Builder builder){
        this.name = builder.name;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
    }
    
    // Getters (no setters1)

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("WithBuilder {").append("\n");
        sb.append("name = ").append(name).append("\n");
        sb.append("age = ").append(age).append("\n");
        sb.append("phone = ").append(phone).append("\n");
        sb.append("address = ").append(address).append("\n");

        return sb.toString();
    }

    // Inner Builder Class

    public static class Builder{
     
    private final String name;
     // Optional parameters
    private  int age;
    private  String phone;
    private  String address;

     public Builder(String name){
        this.name = name;
        
    }

    public Builder age(int age){
        this.age = age;
        return this;
    }

    public Builder phone(String phone){
        this.phone = phone;
        return this;
    }

    public Builder address(String address){
        this.address = address;
        return this;
    }

    public WithBuilder build(){
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name is required and cannot be empty");
        }
        if (age <= 0){
            throw new IllegalArgumentException("Age cannot be negative nor zero");
        }

        return new WithBuilder(this);
    }

}

public static void main(String[]args){
    WithBuilder user1 = new WithBuilder.Builder("Bob")
                .age(25)
                .phone("+250781828671")
                .address("Rwanda")
                .build();

    System.out.println(user1);

    // Testing validation

    try{
        WithBuilder  user2 = new WithBuilder.Builder("")
                     .age(25)
                     .build();
    } catch (IllegalArgumentException e){
        System.out.println("Validation caught the error: " + e.getMessage());
    }
}


   
}
