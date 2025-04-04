package topic.problemssolving.commonproblems;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Given an array of integers arr[], the task is to move all the zeros to the end of the array while maintaining the relative order of all non-zero elements.<br><br>
 * Examples:<br><br>
 * Input: arr[] = [1, 2, 0, 4, 3, 0, 5, 0]<br>
 * Output: arr[] = [1, 2, 4, 3, 5, 0, 0, 0]<br>
 * Explanation: There are three 0s that are moved to the end.<br><br>
 * Input: arr[] = [10, 20, 30]<br>
 * Output: arr[] = [10, 20, 30]<br>
 * Explanation: No change in array as there are no 0s.<br><br>
 * Input: arr[] = [0, 0]<br>
 * Output: arr[] = [0, 0]<br>
 * Explanation: No change in array as there are all 0s.
 */
public class MoveAllZeroToEndOfArray {

    public static void main(String[] args) {

        int[] inputArray1={1, 2, 0, 4, 3, 0, 5, 0};
        int[] inputArray2={10, 20, 30};
        int[] inputArray3={0,0};

        System.out.println(Arrays.toString(moveAllZeroToEnd(inputArray1)));
        System.out.println(Arrays.toString(moveAllZeroToEnd(inputArray2)));
        System.out.println(Arrays.toString(moveAllZeroToEnd(inputArray3)));

    }

    /**
     *
     * Time complexity = O(N) <br>
     * Space = O(1)
     *
     */
    private static int[] moveAllZeroToEnd(int[] inputArray) {

        int count=0;

        for(int i=0;i<inputArray.length;i++){

            if(inputArray[i]!=0){
                int temp=inputArray[i];
                inputArray[i]=inputArray[count];
                inputArray[count]=temp;
                count++;

            }

        }

        return inputArray;

    }
}
