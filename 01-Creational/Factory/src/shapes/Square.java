package shapes;

public class Square implements Shape {
    
    private double side;

    public Square(double side){
        this.side = side;
    }

    @Override
    public void draw(){
        System.out.println("Drawing a Square with side " + side);
    }

    @Override
    public double area(){
        return side * side;
    }
}
