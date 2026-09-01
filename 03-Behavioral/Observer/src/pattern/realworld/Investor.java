package pattern.realworld;

public class Investor {
    
    private String name;

    public Investor(String name) {
        this.name = name;
    }

    public void update(Stock stock) {
        System.out.println("📈" + name + " notified: " + stock.getSymbol() + " is now $" + stock.getPrice());
    }
}
