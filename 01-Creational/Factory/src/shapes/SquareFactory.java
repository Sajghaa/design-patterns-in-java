package shapes;

public class SquareFactory extends ShapeFactory {
    @Override
    public Shape createShape(double... params){
        if (params.length < 1) throw new IllegalArgumentException("Square needs side");
        return new Square(params[0]);
    }
    
}
