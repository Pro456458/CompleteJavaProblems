package topic.client.expedia;

import java.util.Arrays;
import java.util.List;

/**
 *Problem: find the start and end index of the continuous unsorted sub-array within a partially sorted array in Java.
 * such that if you only sort this sub-array in non-decreasing order, then the whole array will be sorted in non-decreasing order.
 */
public class UnsortedSubArray {

    public static void main(String[] args) {

        List<int[]> testArrays = getTestArrays();

        for(int[] inputArray : testArrays) {
            System.out.println("find unsorted sub array in :");
            System.out.println(Arrays.toString(inputArray));
            int[] result = findUnsortedSubArray(inputArray);

            System.out.println("Start index: " + result[0]);
            System.out.println("End index: " + result[1]);

            if (result[0] == -1 && result[1] == -1)
                System.out.println("Array is already Sorted");
            else {
                for (int i = result[0]; i <= result[1]; i++) {
                    System.out.print(inputArray[i] + ",");
                }
            }
            System.out.println("\n================");

        }

    }

    private static List<int[]> getTestArrays() {

        return Arrays.asList(
                new int []{2, 6, 4, 8, 10, 9, 15},
                new int []{1, 3, 5, 2, 6, 4, 8, 10},
                new int []{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                new int []{10, 12, 5, 6, 15, 20, 30},
                new int []{1, 3, 2, 4, 5, 6, 7, 8, 9, 10},
                new int []{1, 2, 3, 4, 5, 10, 9, 8, 7, 6}
        );
    }

    private static int[] findUnsortedSubArray(int[] numbs) {

        int n = numbs.length;

        int start=-1;
        int end=-1;


        // Step 1: Find the first element out of order from the left
        for(int i=0; i<n-1; i++){

            if(numbs[i]> numbs[i+1]) {
                start = i;
                break;
            }
        }

        //If the array is already sorted
        if(start == -1)
            return new int[]{-1,-1};


        // Step 2: Find the first element out of order from the right
        for(int i=n-1; i>0; i--){

            if( numbs[i] < numbs[i-1] ){
                end = i;
                break;
            }
        }

        // Step 3: Find the minimum and maximum values in the subarray
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        for(int i = start ; i <= end ; i++){

            if(numbs[i] < minValue  ) minValue = numbs[i];
            if(numbs[i] > maxValue  ) maxValue = numbs[i];

        }

        // Step 4: Expanding the start index to the left
        // Why: We need to include any elements to the left of the identified start index
        // that are greater than the minimum value of the sub-array.
        // This ensures that the entire array is sorted correctly.
        for(int i=0; i<start;i++){
            if(numbs[i]>minValue) {
                start = i;
                break;
            }
        }

        // Step 4: Expanding the start index to the left
        // Why: We need to include any elements to the right of the identified end index
        // that are less than the maximum value of the sub-array.
        // This ensures that the entire array is sorted correctly.
        for(int i=n-1; i>end;i--){
            if(numbs[i]<maxValue) {
                end = i;
                break;
            }
        }

        return new int[]{start,end};
    }


}
