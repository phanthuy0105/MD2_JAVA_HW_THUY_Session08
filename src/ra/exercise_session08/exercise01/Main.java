package ra.exercise_session08.exercise01;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setRadius(3.5);
        System.out.println("Diện tích trước khi tăng kích thước: " + circle.getArea());
        circle.resize(50);
        System.out.println("Diện tích sau khi tăng kích thước: " + circle.getArea());


        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(3);
        rectangle.setHeight(4);
        System.out.println("Diện tích trước khi tăng kích thước: " + rectangle.getArea());
        rectangle.resize(50);
        System.out.println("Diện tích sau khi tăng kích thước: " + rectangle.getArea());

        Square square = new Square();
        square.setWidth(2);
        square.setHeight(2);
        square.getArea();
        System.out.println("Diện tích trước khi tăng kích thước: " + square.getArea());
        square.resize(50);
        System.out.println("Diện tích sau khi tăng kích thước: " + square.getArea());
    }
}
