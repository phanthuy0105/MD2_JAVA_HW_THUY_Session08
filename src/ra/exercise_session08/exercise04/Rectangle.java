package ra.exercise_session08.exercise04;

public class Rectangle extends Shape {
    private double width;
    private double height;
    private double area;

    public Rectangle() {
    }

    public Rectangle(String color, double width, double height, double area) {
        super(color);
        this.width = width;
        this.height = height;
        this.area = area;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public void getArea() {
        area = width * height;
        System.out.println("Diện tích hình chữ nhật là: " + this.area);
    }

    @Override
    public void display() {
        System.out.println("Màu sắc của hình chữ nhật " + super.getColor());
    }
}
