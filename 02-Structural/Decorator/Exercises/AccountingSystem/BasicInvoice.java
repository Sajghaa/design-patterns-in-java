package Decorator.Exercises.AccountingSystem;

public class BasicInvoice implements Invoice{

    private double subtotal;

    public BasicInvoice(double subtotal){
        this.subtotal = subtotal;
    }

    @Override
    public double getAmount(){
        return subtotal;
    }
}