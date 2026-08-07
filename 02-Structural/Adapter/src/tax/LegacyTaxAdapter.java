package tax;

public class LegacyTaxAdapter implements NewTaxCalculator{

    private LegacyTaxSystem legacySystem;

    public LegacyTaxAdapter(LegacyTaxSystem legacySystem){
        this.legacySystem = legacySystem;
    }
    
    @Override
    public double calculateTax(double income, String category){
        if ("Employee".equalsIgnoreCase(category)){
            return legacySystem.calculateTax(income);
        } else if ("Business".equalsIgnoreCase(category)){
            return income * 0.30;
        } else {
            return income * 0.35;
        }
    }
}
