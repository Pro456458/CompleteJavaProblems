package topic.java8concepts.commonproblems;

import topic.java8concepts.beans.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CommonProblemsPractice {

    public static void main(String[] args) {


        makeUpperCaseOfStringSpecificString();


        groupOFEmployeeOnABasisOfTheirSalary();


        operationOnIntArray();


        operationOfCharArrayOrString();


    }

    private static void operationOfCharArrayOrString() {
        String ss = "cabdeabb";
        Map<String,Long> charWithOccurrence= Arrays.stream(ss.split(""))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        charWithOccurrence.forEach((k,v) ->  { if(v>1) System.out.println(k+":"+v); } );


        System.out.println("========1=============");

        Map<String,Long> charWithOccurrence1=Arrays.stream(ss.split(""))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() >1 )
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue ));


        charWithOccurrence1.forEach((k,v) ->  System.out.println(k) );


        System.out.println("======2===========================");


        IntStream chars = ss.chars();

        Stream<Character> characterStream=chars.mapToObj(intChar -> (char) intChar );

        Map<Character,List<Character>>  charsWithCharList=characterStream.
                collect(Collectors.groupingBy(Function.identity()));

        charsWithCharList.forEach((k,v)-> System.out.println(k+":"+v));

        System.out.println("=====3============================");


        Map<Character,Long>  charsWithCount=ss.chars().mapToObj(intChar -> (char) intChar ).
                collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));


        charsWithCount.forEach((k,v) -> System.out.println(k+":"+v));

        System.out.println("=====4============================");


        Set<Map.Entry<Character,Long>> entrySet =ss.chars().mapToObj(intChar -> (char) intChar ).
                collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet();

        Map<Character,Long>  charsWithCount1=entrySet.stream().filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(characterLongEntry -> characterLongEntry.getKey(),
                        characterLongEntry -> characterLongEntry.getValue()));


        charsWithCount1.forEach((k,v) -> System.out.println(k+":"+v));

        System.out.println("=====5============================");


        ss.chars().mapToObj(intChar -> (char) intChar)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue())
                .ifPresent(entry ->

                        System.out.println(
                                "Character with max occurrence: " + entry.getKey()
                                        + " (occurrences: " + entry.getValue() + ")")
                );


        System.out.println("+++=6======+++++++++++++==+++++++++++++++");
    }

    private static void operationOnIntArray() {
        List<Integer> integers= Arrays.asList(1,2,3,4,5,6,7,8,9);
        System.out.println("Find sum of integers :"+ integers);

        Integer sumInteger=integers.stream().reduce(0,Integer::sum);

        System.out.println(sumInteger);


        System.out.println("Group Odd and Even Integer :"+ integers);

        Map<Boolean,List<Integer>> integersWithEvenAndOdds=integers.stream()
                .collect(Collectors.partitioningBy(integer -> integer%2==0));


        integersWithEvenAndOdds.forEach((k,v)-> System.out.println(k+":"+v));
    }

    private static void groupOFEmployeeOnABasisOfTheirSalary() {
        List<Employee> employees = List.of(
                new Employee("Pro",30,50000),
                new Employee("Pro1",35,60000),
                new Employee("Pro2",40,50000),
                new Employee("Pro3",45,60000)
        );

        System.out.println("Group employee on the basis of there salary");
        System.out.println(employees);

        Map<Double, Long> collect =
                employees.stream().collect(Collectors.groupingBy(Employee::getSalary,Collectors.counting()));

        collect.forEach((k,v) -> System.out.println(k+":"+v));
    }

    private static void makeUpperCaseOfStringSpecificString() {
        List<String> strings= Stream.of("abcnd","asd","aas","qweret").toList();

        System.out.println("In a Given list of String make uppercase of those string whose length is less then 5");
        System.out.println(strings);


        strings.stream().filter(string -> string.length()<5)
                        .map(String::toUpperCase).forEach(System.out::println);
    }
}
