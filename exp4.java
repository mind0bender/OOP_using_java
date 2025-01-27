interface Shape {
    double area();

    double perimeter();
}

class Circle implements Shape {
    private double radius;

    public Circle(double r) {
        radius = r;
    }

    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}

public class exp4 {

    public static void main(String[] args) {
        Circle ball = new Circle(10);
        System.out.println("Area of the ball is " + ball.area());
        System.out.println("Perimeter of the ball is " + ball.perimeter());
    }
}