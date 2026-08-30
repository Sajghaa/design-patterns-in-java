package pattern.travel;

public class TravelContext {
 
    private FareStrategy strategy;

    public void setFareStrategy(FareStrategy strategy) {
        this.strategy = strategy;
    }

    public void printFare() {
        if (strategy == null) {
            System.out.println(" No fare strategy set!");
        } else {
            System.out.println("Fare: " + strategy.calculateFare() + " RWF ");
        }
    }
}
