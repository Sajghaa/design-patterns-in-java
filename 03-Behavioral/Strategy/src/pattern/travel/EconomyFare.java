package pattern.travel;

public class EconomyFare  implements FareStrategy{
    
    @Override
    public double calculateFare() {
        return 100000.0;
    }
}
