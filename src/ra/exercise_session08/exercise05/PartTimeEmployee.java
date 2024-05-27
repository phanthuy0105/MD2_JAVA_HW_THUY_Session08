package ra.exercise_session08.exercise05;

public class PartTimeEmployee extends Employee {
    private int workingHours;

    public PartTimeEmployee() {
    }

    public PartTimeEmployee(int paymentPerHour, String name, int workingHours) {
        super(paymentPerHour, name);
        this.workingHours = workingHours;
    }

    @Override
    public void calculateSalary() {
        System.out.println("tiền lương của nhân viên partime: " + workingHours * super.getPaymentPerHour());
    }
}
