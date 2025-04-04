package topic.java8concepts.staticdata;

import topic.java8concepts.beans.Person;

import java.util.Arrays;
import java.util.List;

public class PersonStaticData {

    static List<Person> people = Arrays.asList(
            new Person("Alice", 35),
            new Person("Bob", 25),
            new Person("Charlie", 40),
            new Person("David", 32),
            new Person("Eve", 28),
            new Person("Alice", 35) // Duplicate name for testing uniqueness
    );

    public static List<Person> getPeople() {
        return people;
    }
}
