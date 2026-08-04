package Decorator.Exercises.AccountingSystem;

public class InsuranceFeeDecorator extends InvoiceDecorator{

    public InsuranceFeeDecorator(Invoice invoice){
        super(invoice);
    }
    
    @Override
    public double getAmount(){
        return super.getAmount() + 1200;
    }
    
}
