package factory.src;

import factory.src.shapes.*;


public class WithoutFactory {

    // This method is the problem - it knows about EVERY concrete class
    public static Shape createShape(String type, double... params) {
        if (type == null) {
            throw new IllegalArgumentException("Type cannot be null");
        }

        if (type.equalsIgnoreCase("circle")) {
            if (params.length < 1) throw new IllegalArgumentException("Circle needs radius");
            return new Circle(params[0]);
        } else if (type.equalsIgnoreCase("square")) {
            if (params.length < 1) throw new IllegalArgumentException("Square needs side");
            return new Square(params[0]);
        } else if (type.equalsIgnoreCase("triangle")) {
            if (params.length < 2) throw new IllegalArgumentException("Triangle needs base and height");
            return new Triangle(params[0], params[1]);
        } else {
            throw new IllegalArgumentException("Unknown shape type: " + type);
        }
    }

    public static void main(String[] args) {
        // This client code is tightly coupled to the 'createShape' method
        Shape circle = WithoutFactory.createShape("circle", 5.0);
        Shape square = WithoutFactory.createShape("square", 4.0);
        Shape triangle = WithoutFactory.createShape("triangle", 3.0, 6.0);

        circle.draw();
        square.draw();
        triangle.draw();

        System.out.println("Circle area: " + circle.area());
        System.out.println("Square area: " + square.area());
        System.out.println("Triangle area: " + triangle.area());

    }
}