package tax;

public class TaxAdapterDemo {
    
    public static void main(String[]args){
        double income = 100000.0;

        LegacyTaxSystem legacy = new LegacyTaxSystem();
        NewTaxCalculator adapter = new LegacyTaxAdapter(legacy);

        System.out.println("Employee Tax (20%): " + adapter.calculateTax(income,"Employee"));
        System.out.println("Business Tax (30%): " + adapter.calculateTax(income, "Business"));
        System.out.println("Freelancer Tax (35%): " + adapter.calculateTax(income, "Freelancer"));
    }

}
