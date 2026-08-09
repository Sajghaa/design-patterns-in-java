package shapes;

public class CircleFactory extends ShapeFactory {
    @Override
    public Shape createShape(double... params){
        if (params.length < 1) throw new IllegalArgumentException("Circle needs radius");
            return new Circle(params[0]);
    }
}
