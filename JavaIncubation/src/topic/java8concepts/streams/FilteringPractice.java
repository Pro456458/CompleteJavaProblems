package topic.java8concepts.streams;

import topic.java8concepts.staticdata.EmployeesStaticData;
import topic.java8concepts.beans.Employee;

import java.util.List;
import java.util.function.Predicate;

public class FilteringPractice {

    public static void main(String[] args) {

        int ageThreshold;
        double salaryThreshold;
        char startingLetter;

        List<Employee> easternUSBaseEmployees = EmployeesStaticData.getEasternUSBaseEmployees();
        printEmployees(easternUSBaseEmployees);

/*
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter age threshold:");
        ageThreshold = scanner.nextInt();

        System.out.println("Enter salary threshold:");
        salaryThreshold = scanner.nextDouble();

        System.out.println("Enter starting letter for names:");
        startingLetter = scanner.next().charAt(0);
*/
        // if need to paas dynamic value to test multiple scenario
        //comment below line uncomment above code
        ageThreshold=30;salaryThreshold=90000;startingLetter='A';

        showFilteredEmployeeAsPerPredicates(ageThreshold, salaryThreshold, startingLetter, easternUSBaseEmployees);

        otherFiltersExample(easternUSBaseEmployees);


    }
    private static void otherFiltersExample(List<Employee> employees) {

        Predicate<Employee> agePredicate;
        Predicate<Employee> salaryPredicate;
        Predicate<Employee> namePredicate;

        System.out.println("Filter employees with age greater than 30 and salary greater than 60000:");

        agePredicate = employee -> employee.getAge() > 30 ;
        salaryPredicate = employee -> employee.getSalary() > 60000;

        List<Employee> list = employees.stream().filter(agePredicate.and(salaryPredicate)).toList();
        printEmployees(list);

        System.out.println("Filter employees with age less than 30 \nor salary less than 50000:");
        agePredicate = employee -> employee.getAge() < 30;
        salaryPredicate = employee ->  employee.getSalary() < 50000;

        List<Employee> list1 = employees.stream().filter(agePredicate.or(salaryPredicate)).toList();
        printEmployees(list1);


        System.out.println("Filter employees whose name does not start with 'A' \nand age greater than 25:");
        namePredicate = employee -> !employee.getName().startsWith("A");
        agePredicate = employee -> employee.getAge() > 25;

        List<Employee> list2 = employees.stream().filter(namePredicate.and(agePredicate)).toList();
        printEmployees(list2);

        System.out.println("Filter employees with salary greater than 50000 \nor name starts with 'D', \nand negate the condition for age greater than 40:");

        agePredicate = employee -> employee.getAge()> 40;
        namePredicate = employee -> employee.getName().startsWith("D");
        salaryPredicate = employee -> employee.getSalary() > 50000;

        List<Employee> list3 = employees.stream().
                filter(salaryPredicate.or(namePredicate).and(agePredicate.negate()))
                .toList();
        printEmployees(list3);
    }

    private static void showFilteredEmployeeAsPerPredicates(int ageThreshold, double salaryThreshold, char startingLetter, List<Employee> easternUSBaseEmployees) {

        Predicate<Employee> agePredicate = getAgePredicate(ageThreshold);
        Predicate<Employee> salaryPredicate = getSalaryPredicate(salaryThreshold);
        Predicate<Employee> namePredicate = getNamePredicate(startingLetter);


        List<Employee> filteredEmployee = easternUSBaseEmployees.stream()
                .filter(agePredicate.and(salaryPredicate).or(namePredicate)).toList();

        System.out.println("Filter employee whose \nage is > "+ ageThreshold
                +"\nand salary is > "+ salaryThreshold
                +"\nor name start with "+ startingLetter);

        System.out.println("Output");
        printEmployees(filteredEmployee);
    }

    private static void printEmployees(List<Employee> employee) {
        employee.forEach(System.out::println);
        System.out.println("XX============XX+=============XX==============XX\n");
    }

    private static Predicate<Employee> getNamePredicate(char startingLetter) {
        return employee -> employee.getName().startsWith(String.valueOf(startingLetter));
    }

    private static Predicate<Employee> getSalaryPredicate(double salaryThreshold) {
        return employee -> employee.getSalary() > salaryThreshold;
    }

    private static Predicate<Employee> getAgePredicate(int ageThreshold) {
        return employee ->  employee.getAge() > ageThreshold;
    }

}
