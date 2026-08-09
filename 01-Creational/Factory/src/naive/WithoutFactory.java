package naive;


interface Shape{
    void draw();
}

class Circle implements Shape{
    @Override
    public void draw(){
        System.out.println("Drawing Circle");
    }
}

class Square implements Shape{
    @Override
    public void draw(){
        System.out.println("Drawing Square");
    }
}

class Triangle implements Shape{
    @Override
    public void draw(){
        System.out.println("Drawing Triangle");
    }
}


public class WithoutFactory {

    public static Shape createShape(String type){
        if (type ==  null) return null;

        if (type.equalsIgnoreCase("circle")) return new Circle();

        else if (type.equalsIgnoreCase("square")) return new Square();

        else if (type.equalsIgnoreCase("triangle")) return new Triangle();

        else throw new IllegalArgumentException("Unknown type: " + type);
    }

    public static void main(String []args){
        Shape s1 = createShape("circle");
        s1.draw();

        Shape s2 = createShape("square");
        s2.draw();

        System.out.println("Adding Pentagon forces me to modify createShape()");
    }
    
}
