package topic.designpattern.creational.builder;

public class TestBuilderDesignPattern {

    public static void main(String[] args) {

        Employee employee= new Employee.EmployeeBuilder()
                .setName("Pro")
                .setAge(30)
                .setAddress("XYZ")
                //.setPhoneNumber("98765432")
                .build();

        System.out.println(employee.toString());

    }
}
