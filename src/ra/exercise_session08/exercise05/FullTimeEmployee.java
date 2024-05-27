package ra.exercise_session08.exercise05;

public class FullTimeEmployee extends Employee {
    @Override
    public void calculateSalary() {
        System.out.println("tiền lương fulltime: " + 8 * super.getPaymentPerHour());
    }
}
