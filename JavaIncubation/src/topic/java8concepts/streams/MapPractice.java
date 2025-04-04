package topic.java8concepts.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class MapPractice {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("  hello  ", "world", "  java  ", null, "");

        // Function to convert string to uppercase and trim it
        // can use UnaryOperator<String> as well to replace below Function
        Function<String, String> toUpperCaseAndTrim = s -> {
            if (s == null) {
                return "";
            }
            return s.trim().toUpperCase();
        };


        // Function to calculate the length of a string
        Function<String, Integer> calculateLength = s -> {
            if (s == null) {
                return 0;
            }
            return s.length();
        };

        // Chaining functions using andThen()
        Function<String, Integer> processAndCalculateLength = toUpperCaseAndTrim.andThen(calculateLength);

        // Processing the list of strings
        List<Integer> lengths = strings.stream()
                .map(processAndCalculateLength)
                .toList();

        // Output the results
        lengths.forEach(System.out::println);
    }
}
