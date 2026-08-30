package pattern.travel;

public class FirstClassFare implements FareStrategy {
    
    @Override
    public double calculateFare() {
        return 300000.0;
    }
}
