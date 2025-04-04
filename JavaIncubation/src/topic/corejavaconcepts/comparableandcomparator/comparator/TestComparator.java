package topic.corejavaconcepts.comparableandcomparator.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestComparator {

    public static void main(String[] args) {

        List<ComparatorEmployee> employees = new ArrayList<>();
        employees.add(new ComparatorEmployee(1, "Bob"));
        employees.add(new ComparatorEmployee(2, "Charlie"));
        employees.add(new ComparatorEmployee(2, "Alice"));

        System.out.println("List of employee before sorting");
        employees.forEach(System.out::println);

        //1- Comparator for sorting by Id
        Comparator<ComparatorEmployee> comparingById = Comparator.comparingInt(ComparatorEmployee::getId);

        // using Integer.compare is also fine as Comparator.comparingInt() method internally use Integer.compare() method
        //Comparator<ComparatorEmployee> comparingById = (e1,e2) -> Integer.compare(e1.getId(),e2.getId());

        Collections.sort(employees,comparingById);

        System.out.println("Sorted by id:");
        employees.forEach(System.out::println);



        //2- Comparator for sorting by Name
        Comparator<ComparatorEmployee> comparingByName = (e1,e2) -> e1.getName().compareTo(e2.getName());

        employees.sort(comparingByName);
        //Collections.sort() and list.sort both server same functionality
        //Collections.sort(employees,comparingByName);


        System.out.println("Sorted by Name:");
        employees.forEach(System.out::println);




        //3- Comparator for sorting by Id and name
        Comparator<ComparatorEmployee> comparingByIdAndName = (e1,e2) -> {
            int compare = Integer.compare(e1.getId(), e2.getId());
            return (compare!=0) ? compare : e1.getName().compareTo(e2.getName());
        };

        Collections.sort(employees,comparingByIdAndName);

        System.out.println("Sorted by Id and Name:");
        employees.forEach(System.out::println);


        //we can replace 3rd comparator with the help of method chaining provided by Comparator class
        //4- Comparator for sorting by Id then name
        Comparator<ComparatorEmployee> byIdThenName = comparingById.thenComparing(comparingByName);

        Collections.sort(employees,byIdThenName);

        System.out.println("Sorted by Id then Name:");
        employees.forEach(System.out::println);



    }
}
