package shapes;

public class FactoryDemo {
    
    public static void main(String[] args){

        ShapeFactory factory;

        factory = new CircleFactory();
        Shape circle = factory.createShape(5.0);
        circle.draw();
        System.out.println("Area: " + circle.area());

        factory = new SquareFactory();
        Shape square = factory.createShape(4.0);
        square.draw();
        System.out.println("Area: " + square.area());

        System.out.println("\n OCP Achieved! Adding Pentagon ZERO changes to existing factory classes.");
    }
}
