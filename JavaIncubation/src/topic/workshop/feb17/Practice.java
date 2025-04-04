package topic.workshop.feb17;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Practice {

    public static void main(String[] args) {

        streamProblem1();
        sortListOfString();

    }

    /**
     * Sort List of String without using in-build collections
     * {"New York", "New Jersey", "New Town"}
     * output :
     * New Jersey
     * New Town
     * New York
     */
    private static void sortListOfString() {
        List<String> cities = Arrays.asList("New York", "New Jersey", "New Town");
        System.out.println("Sort Name Of City:"+cities);
        System.out.println("Using Inbuilt Feature:");
        sortingListOFStringUsingInbuiltFeature(cities);

        System.out.println("Without Using Inbuilt Feature:");
        String[] cityArray= cities.toArray(new String[0]);
        sortStringArrayUSingBubbleSort(cityArray);
        System.out.println("=>:"+Arrays.toString(cityArray));
    }

    private static void sortStringArrayUSingBubbleSort(String[] cities) {
        int n= cities.length;

        for(int i=n-1; i>0; i--){

            for(int j=0;j<i;j++){

                int comparison = compareTo(cities[j], cities[j+1]);

                if(comparison>0){
                    String temp= cities[j+1];
                    cities[j+1]= cities[j];
                    cities[j]=temp;
                }

            }
        }
    }


    private static int compareTo(String s1,String s2){

        int len1=s1.length();
        int len2=s2.length();

        int min=Math.min(len1,len2);

        int i=0;

        char[] s1CharArray=s1.toCharArray();
        char[] s2CharArray=s2.toCharArray();

        while(i<min){
            char ch1 =s1CharArray[i];
            char ch2 =s2CharArray[i];

            if(ch1!=ch2)
                return ch1-ch2;
            i++;
        }

        return len1-len2;

    }


    private static void sortingListOFStringUsingInbuiltFeature(List<String> cities) {

        //All below method provide same functionality
//        Comparator<String> stringComparator = (s1,s2) -> s1.compareTo(s2);
//        cities.stream().sorted(stringComparator).forEach(System.out::println);
        //===================================
//        cities.stream().sorted(Comparator.naturalOrder() ).forEach(System.out::println);
        //===================================
        cities.stream().sorted().forEach(System.out::println);
    }

    private static void streamProblem1() {
        //1. Transform a List of integers to square each even element and skip all the odd numbers from output
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.stream().filter(num -> num%2==0).map(num -> num*num ).forEach(System.out::println);
    }
}
