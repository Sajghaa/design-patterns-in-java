package pattern.realworld;

public class StockMarketDemo {
    
    public static void main(String[] args) {
        Stock apple = new Stock("AAPL", 150.0);
    Stock google = new Stock("GOOGL", 2800.0);

    Investor elon = new Investor("Elon Must");
    Investor warren = new Investor("Warren Buffet");
    Investor cathie = new Investor("Cathie Wood");

    apple.attach(elon);
    apple.attach(warren);
    google.attach(cathie);
    google.attach(warren);

    System.out.println("=== Stock Market Live ===");
    apple.setPrice(155.0);
    google.setPrice(2850.0);
    apple.setPrice(160.0);

    System.out.println("\n Adding investors does NOT affect Stock class!");
    }
    

}
