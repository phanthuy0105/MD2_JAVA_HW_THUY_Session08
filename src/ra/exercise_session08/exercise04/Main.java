package ra.exercise_session08.exercise04;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setRadius(3);
        circle.getArea();
        circle.display();


        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(2);
        rectangle.setHeight(3);
        rectangle.getArea();
        rectangle.display();
    }
}
