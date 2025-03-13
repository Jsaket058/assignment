class Shape {
    public void area(int side) {
        System.out.println("Square Area: " + (side * side));
    }

    public void area(int length, int breadth) {
        System.out.println("Rectangle Area: " + (length * breadth));
    }
}

class Circle extends Shape {
    @Override
    public void area(int radius) {
        System.out.println("Circle Area: " + (Math.PI * radius * radius));
    }
}

public class OOP2{
    public static void main(String[] args) {
        Shape shape = new Shape();
        shape.area(5);       
        shape.area(4, 6);     

        System.out.println();

        Circle circle = new Circle();
        circle.area(7);       
    }
}
