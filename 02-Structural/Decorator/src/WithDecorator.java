package decorator.src;


public class WithDecorator {


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


    static abstract class PizzaDecorator implements Pizza {
        protected Pizza wrappedPizza; // Composition!

        public PizzaDecorator(Pizza wrappedPizza) {
            this.wrappedPizza = wrappedPizza;
        }

        // Delegates to the wrapped object
        @Override
        public String getDescription() {
            return wrappedPizza.getDescription();
        }

        @Override
        public double getCost() {
            return wrappedPizza.getCost();
        }
    }

    
    static class CheeseDecorator extends PizzaDecorator {
        public CheeseDecorator(Pizza wrappedPizza) {
            super(wrappedPizza);
        }

        @Override
        public String getDescription() {
            return super.getDescription() + " + Cheese";
        }

        @Override
        public double getCost() {
            return super.getCost() + 2.0;
        }
    }

    static class OliveDecorator extends PizzaDecorator {
        public OliveDecorator(Pizza wrappedPizza) {
            super(wrappedPizza);
        }

        @Override
        public String getDescription() {
            return super.getDescription() + " + Olive";
        }

        @Override
        public double getCost() {
            return super.getCost() + 1.0;
        }
    }

    static class MushroomDecorator extends PizzaDecorator {
        public MushroomDecorator(Pizza wrappedPizza) {
            super(wrappedPizza);
        }

        @Override
        public String getDescription() {
            return super.getDescription() + " + Mushroom";
        }

        @Override
        public double getCost() {
            return super.getCost() + 1.5;
        }
    }


    public static void main(String[] args) {
        System.out.println("=== DECORATOR PATTERN (Composition) ===");

        Pizza plain = new PlainPizza();
        Pizza cheeseOnly = new CheeseDecorator(new PlainPizza());
        Pizza cheeseOlive = new CheeseDecorator(new OliveDecorator(new PlainPizza()));
        Pizza deluxe = new MushroomDecorator(new CheeseDecorator(new OliveDecorator(new PlainPizza())));

        System.out.println(plain.getDescription() + " -> $" + plain.getCost());
        System.out.println(cheeseOnly.getDescription() + " -> $" + cheeseOnly.getCost());
        System.out.println(cheeseOlive.getDescription() + " -> $" + cheeseOlive.getCost());
        System.out.println(deluxe.getDescription() + " -> $" + deluxe.getCost());

        System.out.println("\n✅ To add Pepperoni: Just create PepperoniDecorator. No existing code changes!");
        System.out.println("✅ Also, notice PizzaDecorator IMPLEMENTS the SAME interface (Pizza).");
        System.out.println("   This is the DEAD GIVEAWAY that it's DECORATOR, not ADAPTER.");
        System.out.println("   (Adapter would implement a DIFFERENT interface).");
    }
}