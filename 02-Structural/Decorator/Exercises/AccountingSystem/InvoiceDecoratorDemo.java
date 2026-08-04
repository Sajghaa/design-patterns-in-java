package Decorator.Exercises.AccountingSystem;

public class InvoiceDecoratorDemo {
    public static void main(String[]args){
        Invoice basic = new BasicInvoice(500);
        System.out.println("Basic Invoice: " + basic.getAmount());

        Invoice withDelivery = new DeliveryFeeDecorator(basic);
        System.out.println("With delivery: " + withDelivery.getAmount());

        Invoice withBoth = new InsuranceFeeDecorator(withDelivery);
        System.out.println("With delivery + insurance: " + withBoth.getAmount());

        Invoice full = new InsuranceFeeDecorator(
            new DeliveryFeeDecorator(
                new BasicInvoice(500)
            )
        );
        System.out.println("Final amount: " + full.getAmount());
    }
}

