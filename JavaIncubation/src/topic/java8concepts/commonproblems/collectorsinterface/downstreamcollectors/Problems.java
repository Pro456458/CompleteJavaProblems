package topic.java8concepts.commonproblems.collectorsinterface.downstreamcollectors;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Problems {

    public static void main(String[] args) {

        countingWordByLength();
        summarizeAgeOfPersons();
        averagingAgeOfPersons();

    }


    /**
     * CountingWordByLength<br>
     * Problem : Counting Words by Length<br>
     * Description: Given a list of words with different length, count how many words there are of each length.<br>
     * i.e. Group By words length with its count<br>
     * world length  = Words Count<br>
     *             3 = 1<br>
     *             4 = 1<br>
     *             5 = 2<br>
     *             6 = 2<br>
     */
    private static void countingWordByLength() {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");

        words.stream().collect( Collectors.groupingBy(String::length, Collectors.counting()) )
                .forEach((k, v) -> System.out.println(k+"="+v));
    }


    /**
     * Problem: Summarizing Ages of People
     * Description: Given a list of people with their ages, summarize the age statistics (count, sum, min, average, max).
     */
    private static void summarizeAgeOfPersons() {

        List<Person> people=listOfPerson();

        System.out.println("Given List of Person :"+people);

        IntSummaryStatistics ageSummaryStatistics =people.stream().collect(Collectors.summarizingInt(Person::getAge));

        System.out.println("Age Summary Statistics of persons");
        System.out.println(ageSummaryStatistics);

    }

    private static List<Person> listOfPerson(){

        return  Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35),
                new Person("David", 40),
                new Person("Eve", 28)
        );

    }



    //Created a temp dummy Person class to demonstrate the use of summarizeInt downstream method
    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    /**
     * Problem 1: Averaging Ages of People
     * Description: Given a list of people with their ages, calculate the average age.
     */
    private static void averagingAgeOfPersons() {

        List<Person> people = listOfPerson();

        Double averageAge =people.stream().collect(Collectors.averagingInt(Person::getAge));
        System.out.println("Average Age of persons");
        System.out.println(averageAge);

    }



}
