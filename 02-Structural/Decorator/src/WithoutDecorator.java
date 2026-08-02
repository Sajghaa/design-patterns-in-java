public class WithoutDecorator {


    

    interface Pizza {
        String getDescription();
        double getCost();
    }


    static class PlainPizza implements Pizza {
        @Override
        public String getDescription() { return "Plain Pizza"; }
        @Override
        public double getCost() { return 10.0; }
    }


    static class CheesePizza extends PlainPizza {
        @Override
        public String getDescription() { return "Plain Pizza + Cheese"; }
        @Override
        public double getCost() { return 10.0 + 2.0; }
    }
    
    static class OlivePizza extends PlainPizza {
        @Override
        public String getDescription() { return "Plain Pizza + Olive"; }
        @Override
        public double getCost() { return 10.0 + 1.0; }
    }
    
    static class MushroomPizza extends PlainPizza {
        @Override
        public String getDescription() { return "Plain Pizza + Mushroom"; }
        @Override
        public double getCost() { return 10.0 + 1.5; }
    }

 
    static class CheeseOlivePizza extends PlainPizza {
        @Override
        public String getDescription() { return "Plain Pizza + Cheese + Olive"; }
        @Override
        public double getCost() { return 10.0 + 2.0 + 1.0; }
    }
    
    static class CheeseMushroomPizza extends PlainPizza {
        @Override
        public String getDescription() { return "Plain Pizza + Cheese + Mushroom"; }
        @Override
        public double getCost() { return 10.0 + 2.0 + 1.5; }
    }
    
    static class OliveMushroomPizza extends PlainPizza {
        @Override
        public String getDescription() { return "Plain Pizza + Olive + Mushroom"; }
        @Override
        public double getCost() { return 10.0 + 1.0 + 1.5; }
    }

  
    static class CheeseOliveMushroomPizza extends PlainPizza {
        @Override
        public String getDescription() { return "Plain Pizza + Cheese + Olive + Mushroom"; }
        @Override
        public double getCost() { return 10.0 + 2.0 + 1.0 + 1.5; }
    }

    public static void main(String[] args) {
        System.out.println("=== NAIVE DECORATOR (Class Explosion) ===");
        PlainPizza p1 = new PlainPizza();
        CheesePizza p2 = new CheesePizza();
        CheeseOlivePizza p3 = new CheeseOlivePizza();
        CheeseOliveMushroomPizza p4 = new CheeseOliveMushroomPizza();

        System.out.println(p1.getDescription() + " -> $" + p1.getCost());
        System.out.println(p2.getDescription() + " -> $" + p2.getCost());
        System.out.println(p3.getDescription() + " -> $" + p3.getCost());
        System.out.println(p4.getDescription() + " -> $" + p4.getCost());
        
        System.out.println("\n❌ PROBLEM: To add Pepperoni, we need 8 MORE subclasses (PepperoniPizza, CheesePepperoniPizza, OlivePepperoniPizza...). This is unmaintainable!");
    }
}