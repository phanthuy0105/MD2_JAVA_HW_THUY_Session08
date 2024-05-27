package ra.exercise_session08.exercise04;

public class Circle extends Shape {
    private double radius;
    private double area;

    public Circle() {
    }

    public Circle(String color, double radius, double area) {
        super(color);
        this.radius = radius;
        this.area = area;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public void getArea() {
        area = radius * radius * Math.PI;
        System.out.println("Diện tích hình tròn là: " + this.area);
    }

    @Override
    public void display() {
        System.out.println("Màu sắc của hình tròn: " + super.getColor());
    }
}
