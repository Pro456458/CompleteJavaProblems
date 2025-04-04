package topic.problemssolving.searching;

import java.util.Arrays;

import static java.util.Arrays.binarySearch;
import static topic.problemssolving.searching.LinearSearch.linearSearch;

public class Main {
    public static void main(String[] args) {

        int[] intArray = {10,15,30,12,18};
        System.out.println("Input Array:"+ Arrays.toString(intArray));

        int searchElement=18;
        int searchIndex=linearSearch(intArray, searchElement);
        printIndex(searchIndex, searchElement);

        System.out.println("XX=================XX================XX");

        int[] intArray1 = {10,12,15,18,30};
        System.out.println("Input Array:"+ Arrays.toString(intArray));

        searchElement=19;
        searchIndex=binarySearch(intArray1, searchElement);
        printIndex(searchIndex, searchElement);

    }

    private static void printIndex(int searchIndex, int searchElement) {
        if(searchIndex ==-1){
            System.out.println("element:"+ searchElement +" Not present in array");
        }else {
            System.out.println("element: "+ searchElement +" found at index: "+(searchIndex +1));
        }
    }
}
