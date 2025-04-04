package topic.workshop.feb24;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Practice {
    public static void main(String[] args) {

        sortColors();
        groupAnagrams();
        longestPrefixInListOfString();
    }

    /**
     * Given a list of strings, find the longest common prefix among them.
     * If there is no common prefix, return an empty string "".
     */
    private static void longestPrefixInListOfString() {
        String[] str = {"flower", "flag", "float", "flat"};

        System.out.println("Longest Prefix in List of String");
        System.out.println(Arrays.toString(str));

        System.out.println("==========================");



        Optional<String> longestPrefix = Arrays.stream(str).reduce( (s1,s2) -> {
            int minLength = Math.min(s1.length(),s2.length());
            int i=0;

            while(i<minLength && s1.charAt(i) == s2.charAt(i)){
                i++;
            }
            System.out.println("Longest prefix in s1:"+s1+", s2:"+s2+" :"+s1.substring(0,i));
            return s1.substring(0,i);
        });

        System.out.println(longestPrefix.orElse("no prefix found"));

    }

    /**
     * Given an array of strings, group anagrams together.
     * An anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
     * typically using all the original letters exactly once.
     */
    private static void groupAnagrams() {
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println("Group AnaGrams");
        System.out.println(Arrays.toString(arr));

        groupOfAnagramWithoutJava8(arr);
        groupIfAnagramWithJava8(arr);

    }

    private static void groupIfAnagramWithJava8(String[] arr) {

        Map<String, List<String>> stringWithGroupOfAnagram = Arrays.stream(arr).collect(Collectors.groupingBy(
                s -> {
                    char[] charArray = s.toCharArray();
                    Arrays.sort(charArray);
                    return new String(charArray);
                }
        ));
        System.out.println("grouped anagram with Java 8 groupingBy");
        stringWithGroupOfAnagram.values().forEach(System.out::println);

    }

    private static void groupOfAnagramWithoutJava8(String[] arr) {
        // Create a map to store the sorted string as key and the list of anagrams as value
        Map<String, List<String>> map = new HashMap<>();


        // convert each string to char array, sort the array and convert back to string
        for(String s: arr){

            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);

            // if the sorted string is not present in the map, add it
            if(!map.containsKey(sortedString)){
                map.put(sortedString, new ArrayList<>());
            }

            // add the string to the list of anagrams
            map.get(sortedString).add(s);

        }
        System.out.println("grouped anagram without Java 8 ");
        System.out.println(map.values());
    }

    /**
     *         //int[] arr = {0, 1, 2, 0, 1, 2, 1, 0, 2, 1, 0}
     *         //sort the array into three distinct groups (0s, 1s, and 2s)
     *         // similar to the three colors of the Dutch flag (red, white, and blue).
     *         // This problem is often used to in sorting algorithms and partitioning techniques
     */
    private static void sortColors() {

        usingJava8GroupingBy(new int[]{2, 0, 1, 2, 0, 1, 2, 1, 0, 2, 1, 0});
        usingDutchNationalFlagAlgorithm(new int[]{2, 0, 1, 2, 0, 1, 2, 1, 0, 2, 1, 0});
    }

    /**
     * Dutch National Flag Algorithm (Three-Way Partitioning)
     * Initialize three pointers low, mid, and high to 0, 0, and n-1 respectively.
     *
     */
    private static void usingDutchNationalFlagAlgorithm(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high){

            switch (arr[mid]) {
            case 0:
                swap(arr, low, mid);
                low++;
                mid++;
                break;
            case 1:
                mid++;
                break;
            case 2:
                swap(arr, mid, high);
                high--;
                break;
            }
        }

        System.out.println(Arrays.toString(arr));

    }

    private static void swap(int[] arr, int mid, int high) {
        int temp = arr[mid];
        arr[mid]=arr[high];
        arr[high]=temp;
    }

    /**
     * Counting Sort
     * 1) Count the occurrences of each element (0, 1, and 2).
     * 2) Overwrite the array with the correct number of 0s, 1s, and 2s.
     */
    private static void usingJava8GroupingBy(int[] arr) {

        // Count the occurrences of each element (0, 1, and 2).
        Map<Integer,Long> noWithOccurrence=Arrays.stream(arr).boxed().collect(
                Collectors.groupingBy(Function.identity(), Collectors.counting()));


        // Overwrite the array with the correct number of 0s, 1s, and 2s.
        final int[] i = {0};
        noWithOccurrence.forEach((k,v)->{
            System.out.println("Number "+k+" occurs "+v+" times");
            for(int n = 0; n<v; n++){
                arr[i[0]] =k;
                i[0] = i[0] +1;
            }
        });
        System.out.println("Sorted Array");
        System.out.println(Arrays.toString(arr));
    }
}
