package shapes;

public class TriangleFactory extends ShapeFactory{

    @Override
    public Shape createShape(double... params){
        if (params.length < 2 ) throw new IllegalArgumentException("Triangle needs base and height");
        return new Triangle(params[0], params[1]);
    }
    
}
