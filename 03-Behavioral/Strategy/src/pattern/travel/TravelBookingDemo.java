package pattern.travel;

public class TravelBookingDemo {
    public static void main(String[] args) {
        TravelContext context = new TravelContext();

        context.setFareStrategy(new EconomyFare());
        context.printFare();

        context.setFareStrategy(new BusinessFare());
        context.printFare();

        context.setFareStrategy(new FirstClassFare());
        context.printFare();

        System.out.println("\n OCP Achieved! Adding Student requires ZERO changes to existing strategy classes.");
    }
}
