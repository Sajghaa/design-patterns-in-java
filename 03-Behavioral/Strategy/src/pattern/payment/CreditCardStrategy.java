package pattern.payment;

public class CreditCardStrategy  implements PaymentStrategy{

    private String cardNumber;
    private String cvv;

    public CreditCardStrategy(String cardNumber, String cvv) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }
    @Override
    public void pay(double amount){
        System.out.println("Paid " + amount + " using Credit Card(**** " + cardNumber.substring(cardNumber.length() - 4) + ")");
    }
    
}
