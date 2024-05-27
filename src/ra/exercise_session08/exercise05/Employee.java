package ra.exercise_session08.exercise05;

public abstract class Employee implements IEmployee{
    private String name;
    private int paymentPerHour;

    public Employee() {
    }

    public Employee(int paymentPerHour, String name) {
        this.paymentPerHour = paymentPerHour;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPaymentPerHour() {
        return paymentPerHour;
    }

    public void setPaymentPerHour(int paymentPerHour) {
        this.paymentPerHour = paymentPerHour;
    }
}
