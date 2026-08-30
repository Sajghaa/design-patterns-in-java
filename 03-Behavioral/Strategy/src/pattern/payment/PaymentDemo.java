package pattern.payment;

public class PaymentDemo {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setStrategy(new CreditCardStrategy("1234-5678-9012-3456", "123"));
        context.executePayment(250.00);

        context.setStrategy(new PayPalStrategy("predator@hunting.com"));
        context.executePayment(150.00);

        context.setStrategy(new CryptoStrategy("0xABC123DEF456"));
        context.executePayment(500.00);
    }
}
