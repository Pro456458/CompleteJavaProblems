package topic.designpattern.creational.builder;

public class Employee {

    private String name;
    private int age;
    private String address;
    private String phoneNumber;

    public Employee(EmployeeBuilder employeeBuilder) {
        this.name = employeeBuilder.name;
        this.age = employeeBuilder.age;
        this.address = employeeBuilder.address;
        this.phoneNumber = employeeBuilder.phoneNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public static class EmployeeBuilder{

        private String name;
        private int age;
        private String address;
        private String phoneNumber;


        public EmployeeBuilder setName(String name) {
            this.name = name;
            return this;
        }


        public EmployeeBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public EmployeeBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public EmployeeBuilder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Employee build(){
            return new Employee(this);
        }
    }

}
