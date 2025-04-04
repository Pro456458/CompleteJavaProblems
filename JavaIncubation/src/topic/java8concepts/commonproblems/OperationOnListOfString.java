package topic.java8concepts.commonproblems;


import topic.java8concepts.beans.Employee;
import topic.java8concepts.beans.Jan2025BenchStudent;
import topic.java8concepts.staticdata.EmployeesStaticData;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OperationOnListOfString {

    public static void main(String[] args) {

        removeDuplicateElementFromListOfString();
        findFrequencyOfEachCharacterInString();
        findFrequencyOfEachElementInAnArray();
        sortListOfDecimalsInNaturalAndReverseOrder();
        joinedListOfStringUsingDelimiterPrefixAndSuffix();
        findFrequencyOfEachCharacterInGivenString();

    }

    private static void findFrequencyOfEachCharacterInGivenString() {
        //7) How do you find frequency of each character in a string using Java 8 streams?
        //input  = "bbbccccaa"
        //output = "a2b3c4"
        String s ="bbbccccaa";
        System.out.println(s);
        Map<Character, Long> collect = s.chars().mapToObj(value -> (char) value).collect(
                Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(collect);
    }

    private static void joinedListOfStringUsingDelimiterPrefixAndSuffix() {
        //6) How to Join the given list of strings using Delimiter:"," , Prefix="[" , Suffix:"]" ?
        List<String> listOfStrings = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");
        System.out.println(listOfStrings);
        String joinedListOfString = listOfStrings.stream().collect(Collectors.joining(", ", "[", "]"));
        System.out.println(joinedListOfString);
    }

    private static void sortListOfDecimalsInNaturalAndReverseOrder() {
        //5) How do you sort the given list of decimals in reverse order?
        System.out.println("5) How do you sort the given list of decimals in reverse order?");

        List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);
        System.out.println(decimalList);

        List<Double> sortedDecimalList=decimalList.stream().sorted(Comparator.naturalOrder()).toList();
        System.out.println(sortedDecimalList);

        sortedDecimalList=decimalList.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(sortedDecimalList);
    }

    private static void findFrequencyOfEachElementInAnArray() {
        //4) How do you find frequency of each element in an array or a list?
        System.out.println("4) How do you find frequency of each element in an array or a list?");

        List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler", "Note Book", "Pencil");
        System.out.println(stationeryList);

        Map<String,Long> elementWithFrequency=stationeryList.stream().collect(
                Collectors.groupingBy(Function.identity(), Collectors.counting())
        );

        System.out.println(elementWithFrequency);
    }

    private static void findFrequencyOfEachCharacterInString() {
        //3) How do you find frequency of each character in a string using Java 8 streams?
        System.out.println("3) How do you find frequency of each character in a string using Java 8 streams?");

        String inputString = "Java Concept Of The Day";
        System.out.println(inputString);


        List<Character> characterList = inputString.chars().mapToObj(value -> (char) value).toList();

        Map<Character, Long> characterWithFrequency = characterList.stream().collect(
                Collectors.groupingBy(chars -> chars,  // chars -> chars can be replaced by Function.identity()
                        Collectors.counting())
        );
        System.out.println("output::");
        characterWithFrequency.forEach((key, val) -> System.out.print(key+"::"+val+" , "));
    }

    private static void removeDuplicateElementFromListOfString() {
        //1) How do you remove duplicate elements from a list using Java 8 streams?
        System.out.println("1) How do you remove duplicate elements from a list using Java 8 streams?");

        List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
        System.out.println(listOfStrings);

        List<String> distinctListOfStrings = listOfStrings.stream().distinct().toList();
        System.out.println("output::"+distinctListOfStrings);
    }
}
