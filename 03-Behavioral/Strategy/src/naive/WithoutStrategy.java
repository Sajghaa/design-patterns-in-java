package naive;

public class WithoutStrategy {
    
    public static double calculateFare(String type){
        if (type == null) return 0;
        if (type.equalsIgnoreCase("economy")) {
            return 100000.0;
        } else if (type.equalsIgnoreCase("business")) {
            return 200000.0;
        } else if (type.equalsIgnoreCase("firstclass")){
            return 300000.0;
        } else {
            throw new IllegalArgumentException("Unknown fare type: " + type);
        }
    }

    public static void main(String[] args) {
        System.out.println("Economy Fare: " + calculateFare("economy"));
        System.out.println("Business Fare: " + calculateFare("business"));
        System.out.println("First class Fare: " + calculateFare("fristclass"));
        System.out.println("OCP Violated! Adding Student means modifying this class");
    }
}
