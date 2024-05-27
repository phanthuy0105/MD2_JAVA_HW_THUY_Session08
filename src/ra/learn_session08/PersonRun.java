package ra.learn_session08;

public class PersonRun {
    public static void main(String[] args) {
        //Không thể khởi tạo trực tiếp đối tượng từ lớp trừu tượng
        //Khởi tạo đối tượng gián tiếp
        Person person = new Person() {
            @Override
            public void hello(String name) {
                System.out.println("Xin chào "+name);
            }

            @Override
            public void talk() {
                System.out.println("hello");
            }
        };
    }
}