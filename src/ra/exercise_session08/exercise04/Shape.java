package ra.exercise_session08.exercise04;

public abstract class Shape {

    private String color = "Red";

    public Shape() {
    }

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract void getArea();

    public abstract void display();
}
