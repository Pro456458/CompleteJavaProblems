package topic.java8concepts.commonproblems;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OperationOnListOfInteger {

    public static void main(String[] args) {

        List<Integer> listOfIntegers = getIntegersUsingArraysAsListMethod();
        List<Integer> listOfIntegersUsingArraysStreamMethod =getIntegersUsingArraysStreamMethod();
        List<Integer> listOfIntegersUsingStreamOfMethod = getIntegersUsingStreamOfMethod();

        System.out.println(listOfIntegers);

        System.out.println(listOfIntegersUsingArraysStreamMethod);

        System.out.println(listOfIntegersUsingStreamOfMethod);

        // Transfer List Of Integer to its String representation
        Function<Integer,String> integerStringFunction = num -> String.valueOf(num);
        Function<Integer,String> integerStringFunction1 = String::valueOf;



        //1) Given a list of integers, separate odd and even numbers?
        separateOddAndEvenNumbers(listOfIntegers);

        //2) How do you remove duplicate elements from a list using Java 8 streams?
        List<Integer> distinctListOfIntegers = listOfIntegers.stream().distinct().toList();
        System.out.println(distinctListOfIntegers);

        //3) 1st , 2nd , 3rd largest element in the array
        List<Integer> largest3Element = listOfIntegers.stream().sorted(Comparator.reverseOrder()).limit(3).toList();
        System.out.println(largest3Element);

        //40 Print all number start with 5
        listOfIntegers.stream().filter(num -> String.valueOf(num).startsWith("5")).forEach(System.out::println);



    }

    private static void separateOddAndEvenNumbers(List<Integer> listOfIntegersUsingStreamOfMethod) {
        Map<Boolean, List<Integer>> oddAndEvenNumbers = listOfIntegersUsingStreamOfMethod.stream()
                .collect(Collectors.partitioningBy(number -> number % 2 == 0));

        oddAndEvenNumbers.forEach((aBoolean, integers) ->
                {
                    if (aBoolean)
                        System.out.println("even Number::"+integers);
                    else
                        System.out.println("odd Number::"+integers);
                }
                );


        List<Integer> evenNumbers=oddAndEvenNumbers.entrySet()
                .stream().filter(Map.Entry::getKey)
                .flatMap(entry -> entry.getValue().stream())
                .toList();

        System.out.println("even Number::"+evenNumbers);

        List<Integer> oddNumbers = oddAndEvenNumbers.entrySet()
                .stream().filter(booleanListEntry -> !booleanListEntry.getKey())
                .flatMap(booleanListEntry -> booleanListEntry.getValue().stream())
                .toList();

        System.out.println("odd Number::"+oddNumbers);

        //breakdown of above statement
        Set<Map.Entry<Boolean, List<Integer>>> entrySet = oddAndEvenNumbers.entrySet();
        Stream<Map.Entry<Boolean, List<Integer>>> entryStream = entrySet.stream().filter(Map.Entry::getKey);
        Stream<Integer> integerStream = entryStream.flatMap(booleanListEntry -> booleanListEntry.getValue().stream());
        System.out.println(integerStream.toList());
        System.out.println("=============================");


    }

    /**
     * Purpose: Creates a stream from the provided elements.<br>
     * Usage: Typically used when you want to perform stream operations (like filtering, mapping, etc.) on the elements.
     */
    private static List<Integer> getIntegersUsingStreamOfMethod() {
        return  Stream.of(71, 18, 42, 21, 67, 32, 95, 14, 56, 87).toList();
    }
    /**
    * Purpose: Creates a fixed-size list backed by the specified array.<br>
    * Usage: Used when you need a simple, fixed-size list.
    */
    private static List<Integer> getIntegersUsingArraysAsListMethod() {
        return Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);
    }

    private static List<Integer> getIntegersUsingArraysStreamMethod() {
        int[] intArray={71, 18, 42, 21, 67, 32, 95, 14, 56, 87};
        return Arrays.stream(intArray).boxed().toList();
    }

}
