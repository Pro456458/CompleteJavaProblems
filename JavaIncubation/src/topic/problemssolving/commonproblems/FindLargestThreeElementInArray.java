package topic.problemssolving.commonproblems;

import java.util.*;

/**
 * Largest three distinct elements in an array<br>
 * Given an array arr[], the task is to find the top three largest distinct integers present in the array.<br><br>
 * Note: If there are less than three distinct elements in the array, then return the available distinct numbers in descending order.<br><br>
 * Examples :<br><br>
 * Input: arr[] = [10, 4, 3, 50, 23, 90]<br>
 * Output: [90, 50, 23]<br><br>
 * Input: arr[] = [10, 9, 9]<br>
 * Output: [10, 9]<br>
 * There are only two distinct elements<br><br>
 * Input: arr[] = [10, 10, 10]<br>
 * Output: [10]<br>
 * There is only one distinct element<br><br>
 * Input: arr[] = []<br>
 * Output: []<br>
 */
public class FindLargestThreeElementInArray {

    public static void main(String[] args) {

        int[] inputArray1={10, 4, 3, 50, 23, 90};
        int[] inputArray2={10, 9, 9};
        int[] inputArray3={10, 10, 10};
        int[] inputArray4={};

        System.out.println(findLargestThreeElement(inputArray1));
        System.out.println(findLargestThreeElement(inputArray2));
        System.out.println(findLargestThreeElement(inputArray3));
        System.out.println(findLargestThreeElement(inputArray4));


    }

    /**
     * Complexity: <br>
     * Time O(N) <br>
     * Space O(1) as no extra space required <br>
     */
    private static List<Integer> findLargestThreeElement(int[] inputArray) {

        int fst=Integer.MIN_VALUE;
        int sec=Integer.MIN_VALUE;
        int thd=Integer.MIN_VALUE;

        for (int x : inputArray) {

            if (x > fst) {
                thd = sec;
                sec = fst;
                fst = x;
            } else if (x > sec && x != fst) {
                thd = sec;
                sec = x;
            } else if (x > thd && (x != sec && x != fst)) {
                thd = x;
            }

        }

        List<Integer> integerList = new ArrayList<>();

        if(fst == Integer.MIN_VALUE)
            return integerList;

        integerList.add(fst);

        if(sec == Integer.MIN_VALUE)
            return integerList;

        integerList.add(sec);

        if (thd == Integer.MIN_VALUE)
            return integerList;

        integerList.add(thd);

        return integerList;

    }


}
