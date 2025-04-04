package topic.java8concepts.commonproblems.collectorsinterface;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *   //Given a string s, find the first non-repeating character in it and return its index.
 *   // If there is no such character, return -1.
 *   String s = "aaddwer";  //w-1
 *   String s1 = "aaddww";  //-1
 */
public class FindNonRepeatingCharacter {
    public static void main(String[] args) {

        String[] stringArgs = {"aaddwer", "aaddww"};

        for(String s : stringArgs){
            solution(s);
            System.out.println("========");
        }

    }

    private static void solution(String s) {


        //1- convert String OR char[]  into Stream<Character>
        Stream<Character> characterStream=s.chars().mapToObj(intChar -> (char) intChar);

        //2- groupBy each character with its count of Character Stream
        Map<Character,Long> charsWithCounting=characterStream.collect(
                Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()));

        //3- take a Set Of Each Entry of Map to apply further stream process
        Set<Map.Entry<Character, Long>> entries = charsWithCounting.entrySet();

        //4- filter entries from set having only single count i.e. non-repeating character and find the 1 entry out of that
        Optional<Map.Entry<Character, Long>> optionalEntries =entries.stream()
                .filter( entrySet -> entrySet .getValue()==1 )
                .findFirst();

        //5- print the entry if present else print -1
        System.out.println( (optionalEntries.isPresent()) ? optionalEntries.get() : "-1"  );



        //combine break down operation into single line
        s.chars().mapToObj(intChar -> (char) intChar)
                .collect(Collectors.groupingBy( ch -> ch , LinkedHashMap::new , Collectors.counting() ))
                .entrySet().stream().filter( entrySet -> entrySet.getValue() == 1)
                .findFirst()
                .ifPresentOrElse(
                        chLongEntry -> System.out.println(chLongEntry.getKey()+""+chLongEntry.getValue())
                        , () -> System.out.println("-1")
                );

    }
}
