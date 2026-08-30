package pattern.travel;

public class BusinessFare implements FareStrategy{
 
    @Override
    public double calculateFare() {
        return 200000.0;
    }
}
