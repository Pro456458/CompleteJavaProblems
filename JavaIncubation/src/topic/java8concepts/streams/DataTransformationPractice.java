package topic.java8concepts.streams;

import topic.java8concepts.staticdata.PersonStaticData;
import topic.java8concepts.beans.Person;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Use the `Stream.map()` function to transform a list of objects into a new list of a different type and perform multiple transformations in a pipeline.<br><br>
 * Requirements:<br><br>
 * Define a `Person` class with fields `name` and `age`.<br>
 * Create a list of `Person` objects.<br>
 * Convert the list of `Person` objects into a list of `String` objects containing only the names of people who are older than 30.<br>
 * Chain multiple `map()` operations to:<br>
 * First, extract the names of people who are over 30.<br>
 * Then, transform the names to uppercase.<br>
 * Use `Collectors.toList()` to collect the final results into a list.<br>
 * Ensure that the final list of names contains unique names using `Collectors.toSet()`.<br>
 */
public class DataTransformationPractice {

    public static void main(String[] args) {

        List<Person> peoples = PersonStaticData.getPeople();

        System.out.println(peoples);

        // Transform the list of Person objects into a list of unique names of peoples over 30, in uppercase
        List<String> peoplesName=peoples.stream().filter(people -> people.getAge()>30)
                .map(people -> people.getName().toUpperCase())
                .toList();

        peoplesName.forEach(System.out::println);















        Set<String> uniqueNames = peoples.stream()
                .filter(person -> person.getAge() > 30) // Filter peoples older than 30
                .map(person -> person.getName().toUpperCase()) // Extract names and Transform to uppercase
                .collect(Collectors.toSet()); // Collect unique names into a set

        // Convert the set back to a list if needed
        List<String> uniqueNamesList = uniqueNames.stream().toList();

        // Output the results
        uniqueNamesList.forEach(System.out::println);
    }

}
