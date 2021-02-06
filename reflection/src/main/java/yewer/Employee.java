package yewer;

public class Employee extends Person {
    public static Integer totalNum = 0;
    public int empNo;
    protected String position;
    private int salary;

    public void sayHello() {
        System.out.println("hello,I am :" + this + "my salary=" + salary);
    }

    private void work() {
        System.out.println("work work");
    }

    public Employee(String name, String age, String hobby, int empNo, String position, int salary) {
        super(name, age, hobby);
        this.empNo = empNo;
        this.position = position;
        this.salary = salary;
        Employee.totalNum++;
    }

}
