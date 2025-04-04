package topic.corejavaconcepts.comparableandcomparator.comparable;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestComparable {

    public static void main(String[] args) {

        ComparableEmployee employee1 = new ComparableEmployee(4,"Pro");
        ComparableEmployee employee2 = new ComparableEmployee(4,"Pro");

        System.out.println(employee1.compareTo(employee2)); // true
        System.out.println(employee1.equals(employee2)); // true

        List<ComparableEmployee> employees = new ArrayList<>();
        employees.add(new ComparableEmployee(2, "Alice"));
        employees.add(new ComparableEmployee(1, "Bob"));
        employees.add(new ComparableEmployee(2, "Charlie"));

        System.out.println("List of employee before sorting");
        employees.forEach(System.out::println);

        Collections.sort(employees);

        System.out.println("List of employee after sorting");
        employees.forEach(System.out::println);


        getMaxSalaryEmployeeFromEachDepartment();


    }

    private static void getMaxSalaryEmployeeFromEachDepartment() {
        List<Employee> employeesList = Arrays.asList(
                new Employee("Alice", "HR", 50000),
                new Employee("Bob", "HR", 60000),
                new Employee("Charlie", "IT", 70000),
                new Employee("David", "IT", 80000),
                new Employee("Eve", "Finance", 90000)
        );

        Map<String, Employee> collect = employeesList.stream().collect(Collectors.groupingBy(
                employee -> employee.hr
                , Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparingInt(Employee::getI)), Optional::get
                )

        ));

        collect.forEach((k,v) -> System.out.println(k+":"+v));
    }


}
