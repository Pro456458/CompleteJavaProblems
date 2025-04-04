package topic.java8concepts.staticdata;

import topic.java8concepts.beans.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeesStaticData {

    public static List<Employee> getCentralUSBaseEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Petro",33,100000,"Petro@Gmail.com"));
        employees.add(new Employee("Zee",32,120000,"Zee@Yahoo.com"));
        employees.add(new Employee("Andey",28,80000,"Andey@Gmail.com"));
        employees.add(new Employee("Robat",32,100000,"Robat@Yahoo.com"));
        return employees;
    }

    public static List<Employee> getEasternUSBaseEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 28, 50000));
        employees.add(new Employee("Bob", 35, 60000));
        employees.add(new Employee("Charlie", 32, 70000));
        employees.add(new Employee("David", 25, 40000));
        employees.add(new Employee("Eve", 30, 55000));
        employees.add(new Employee("Frank", 40, 80000));
        employees.add(new Employee("Grace", 45, 90000));
        employees.add(new Employee("Hank", 50, 100000));
        employees.add(new Employee("Ivy", 22, 45000));
        employees.add(new Employee("Jack", 29, 48000));
        return employees;
    }
}
