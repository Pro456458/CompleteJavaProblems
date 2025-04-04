package topic.workshop.feb20;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Practice {

    public static void main(String[] args) {



        //Program to generate Output "a2b3c2" with the input "aabbbcc".
        String input="aabbbcc";
        StringBuilder compressString = compressString(input);
        System.out.println(compressString);



        /**
         * 	find maximum average value.
         * 	[ [ "Bobby", 87 ],
         * 	   [ "Charles", 100 ],
         * 	   [ "Eric", 64 ],
         * 	   [ "Charles", 22 ] ]
         * 	Expected output: 87
         */
        maxAverageScore();


        System.out.println("=== compute the frequency of each unique element in the list using");
        countingFrequencyOfNumber();


        System.out.println("partition the list into two groups based on whether the elements are even or odd");
        partitionTheOddEvenNumber();

        findTheNthLargestElement();

        reverseAString();

        reverseIntegerArray();


    }

    private static void reverseIntegerArray() {
        System.out.println("Reverse a Integer");
        int[] intArray = {1,2,3,4};
        System.out.println(Arrays.toString(intArray));

        //reverse a intArray using java 8
        int[] reversedIntArray = IntStream.range(0, intArray.length)
                .map(i -> intArray[intArray.length - i - 1])
                .toArray();

        System.out.println(Arrays.toString(reversedIntArray));
    }

    private static void reverseAString() {
        System.out.println("Reverse a String");
        String value = "abcd";
        System.out.println(value);
        Stream<String> stream = Arrays.stream(value.split(" "));
        String result=stream.map(str -> new StringBuilder(str).reverse()).collect(Collectors.joining());

        System.out.println(result);
    }

    private static void findTheNthLargestElement() {

        List<Integer> list = List.of(1, 1, 3, 2, 3, 4);
        System.out.println(list);

        Optional<Integer> optionalInt=list.stream().max(Comparator.naturalOrder());
        System.out.println(optionalInt.orElse(null));



    }

    private static void partitionTheOddEvenNumber() {

        List<Integer> list = List.of(1, 1, 3, 2, 3, 4);
        System.out.println(list);

        Map<Boolean, List<Integer>> oddEvenTypeNumbers = list.stream().collect(Collectors.partitioningBy( num -> num%2==0));

        oddEvenTypeNumbers.forEach((k,v) -> System.out.println( ((k)? "odd" : "even") +":"+v));



    }

    private static void countingFrequencyOfNumber() {

        List<Integer> list = List.of(1, 1, 3, 2, 3, 4);

        System.out.println(list);

        Map<Integer, Long> numberWithFrequency = list.
                stream().
                collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                );

        System.out.println("frequency :"+numberWithFrequency);
    }

    /**
     * maximum average value from the given list of scores
     */
    private static void maxAverageScore() {

        List<String[]> scores = Arrays.asList(
                new String[]{"Bobby", "87"},
                new String[]{"Charles", "100"},
                new String[]{"Eric", "64"},
                new String[]{"Charles", "22"}
        );

        Map<String, List<Integer>> playerWithThereScores = scores.stream().collect(

                Collectors.groupingBy(
                        s -> s[0],
                        Collectors.mapping(s -> Integer.parseInt(s[1]) , Collectors.toList()  )
                        )
        );

        playerWithThereScores.forEach((k,v) -> System.out.println(k+":"+v));




    }

    private static StringBuilder compressString(String input) {
        int n= input.length();

        StringBuilder builder = new StringBuilder();
        int count=1;

        for(int i=0;i<=n-1;i++){

            if(i+1 < input.length() && input.charAt(i) == input.charAt(i+1)){
                count++;
            }else {
                builder.append(input.charAt(i)).append(count);
                count = 1;
            }
        }
        return builder;
    }
}
