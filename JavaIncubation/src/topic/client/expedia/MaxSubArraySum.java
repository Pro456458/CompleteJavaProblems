package topic.client.expedia;

import java.util.Arrays;
import java.util.List;

/**
 * Maximum Subarray Sum – Kadane’s Algorithm
 * Given an array arr[], the task is to find the sub-array that has the maximum sum and return its sum.
 */
public class MaxSubArraySum {

    public static void main(String[] args) {
        List<int[]> inputs = List.of(
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9},
                new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1},
                new int[]{2, 3, -8, 7, -1, 2, 3}
        );
        int subArraySize=4;

        for(int[] input : inputs){
            System.out.println("Inputs:"+ Arrays.toString(input));
            System.out.println("===>Sum of Max Sub Array: "+maxSubArraySum(input ));
        }
    }

    private static int maxSubArraySum(int[] input) {

        int n= input.length;
        int maxSum=0;

        for(int i=0; i<=n-1;i++){
            int currentSum=0;

            for(int j=i; j<=n-1; j++){

            }


        }

        return maxSum;
    }
}
