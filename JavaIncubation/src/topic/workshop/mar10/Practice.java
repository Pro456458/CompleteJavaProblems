package topic.workshop.mar10;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Practice {

    public static void main(String[] args) {

        //find most frequent integer from list of integers,
        // if there are more than 1 with same frequency,
        // find the smallest integer among them.



        int[] arr={10,20,20,15,10,5,30,20,30,10};


        Map<Integer,Long> numbersWithCounts = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));


        System.out.println(numbersWithCounts);

        LinkedHashMap<Integer,Long> numbersWithCountingWithSortedOrder=numbersWithCounts.entrySet().stream()
                 .sorted(Comparator.comparingLong(Map.Entry<Integer, Long>::getValue).reversed()
                         .thenComparing(Map.Entry.comparingByKey()))
                 .collect(
                         Collectors.toMap(
                             Map.Entry::getKey,
                             Map.Entry::getValue,
                             (oldValue,newValue) -> oldValue,
                             LinkedHashMap::new)
                 );

        System.out.println(numbersWithCountingWithSortedOrder);

        //=========================================================================

        Map<Integer,Long> frequencyMap=numbersWithCounts.entrySet().stream()
                .sorted(
                        Map.Entry.<Integer, Long>comparingByValue().reversed()
                                .thenComparing(Map.Entry.comparingByKey())
                ).collect(
                        Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (oldValue,newValue) -> oldValue,
                            LinkedHashMap::new)
                );

        System.out.println(frequencyMap);

        //===========================================================================

        Optional<Integer> mostFrequent =numbersWithCounts.entrySet().stream()
                .sorted(
                        Map.Entry.<Integer, Long>comparingByValue().reversed()
                                .thenComparing(Map.Entry.comparingByKey())
                ).map(Map.Entry::getKey).findFirst();

        mostFrequent.ifPresentOrElse(System.out::println, () -> System.out.println("not found"));


        // When you use Map.Entry.comparingByValue(), Java needs to infer the types of the key and value
        // in the map entries. By explicitly specifying the types, you help the compiler understand
        // what types it is dealing with, which can be particularly useful in complex stream operations.



    }
}
