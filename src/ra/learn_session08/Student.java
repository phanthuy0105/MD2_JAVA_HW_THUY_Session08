package ra.learn_session08;

public class Student extends Person {
    //Kế thừa thì phải triển khai các phương thức trừu tượng của lớp cha
    @Override
    public void hello(String name) {
        System.out.println("Xin chào " + name);
    }

    @Override
    public void talk() {
        System.out.println("Nói chuyện với người yêu");
    }
}