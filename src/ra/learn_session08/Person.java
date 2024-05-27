package ra.learn_session08;

public abstract class Person {
    private String name;
    private int age;
    private String address;

    public Person() {
    }

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    //Phương thức triển khai
    public void inputData(){
        System.out.println("Phương thức thực thi nhập dữ liệu cho person");
    }

    public void displayData(){
        System.out.println("Phương thức thực thi hiển thi dữ liệu person");
    }
    //Phương thức trừu tượng
    public abstract void hello(String name);
    public abstract void talk();
}