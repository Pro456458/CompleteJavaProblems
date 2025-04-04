package topic.workshop.feb13;

import topic.java8concepts.beans.Employee;
import topic.java8concepts.staticdata.EmployeesStaticData;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Practice {

    public static void main(String[] args) {

        java8StreamProblem();

    }

    /**
     * //Q8) There is a list of Employees and Employee object has a field called e-mail. Find the list of domains ( gmail.com, yahoo.com..) and the no of occurrences for each domain.
     */
    private static void java8StreamProblem() {


        List<Employee> employees= EmployeesStaticData.getCentralUSBaseEmployees();

        List<String> emails=employees.stream().map(employee ->
            {
                //String[] email=employee.getEmail().split("@"); return email[1];
                return employee.getEmail().substring(employee.getEmail().indexOf("@")+1);
            }
        ).toList();

        Map<String,Long> emailDomainWithOccurrences=emails.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        emailDomainWithOccurrences.forEach((k,v) -> System.out.println(k+":"+v));

        System.out.println("===================");

        employees.stream().collect(Collectors.
                groupingBy(employee-> employee.getEmail().
                        substring(employee.getEmail().indexOf("@")+1) ,
                        Collectors.counting()))
                .forEach((k,v) -> System.out.println(k+":"+v));

        System.out.println("===================");

        employees.stream().collect(Collectors.
                        groupingBy(employee-> employee.getEmail().split("@")[1],
                                Collectors.counting()))
                .forEach((k,v) -> System.out.println(k+":"+v));
    }

}