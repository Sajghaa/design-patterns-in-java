package Decorator.Exercises.AccountingSystem;

public abstract class InvoiceDecorator implements Invoice {
    
    protected Invoice decoratedInvoice;

    public InvoiceDecorator(Invoice invoice){
        this.decoratedInvoice = invoice;
    }

    @Override
    public double getAmount(){
        return decoratedInvoice.getAmount();
    }

}
