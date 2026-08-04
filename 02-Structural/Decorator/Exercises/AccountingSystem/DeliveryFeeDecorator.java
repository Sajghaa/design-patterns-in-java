package Decorator.Exercises.AccountingSystem;

public class DeliveryFeeDecorator extends InvoiceDecorator{
    public DeliveryFeeDecorator(Invoice invoice){
        super(invoice);
    }
    @Override
    public double getAmount(){
        return super.getAmount() + 2000;
    }
    
}
