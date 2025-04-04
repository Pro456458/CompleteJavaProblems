package topic.client.expedia.subarraypattern.fixedlenghtsubarrya;

import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers and a number K, find the maximum sum of a sub-array of size K.<br>
 * Example:<br>
 * Input: arr = [2, 1, 5, 1, 3, 2], K = 3<br>
 * Output: 9<br>
 * Explanation: Sub-array with maximum sum is [5, 1, 3].<br>
 */
public class MaxSumOfSubArray {

    public static void main(String[] args) {
        List<int[]> inputs = List.of(
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9},
                new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1},
                new int[]{2, 1, 5, 1, 3, 2},
                new int[]{2, 3, -8, 7, -1, 2, 3}
        );
        int k=3;
        for(int[] input : inputs){
            System.out.println("Inputs:"+ Arrays.toString(input));
            maxSumOfSubArray(input,k);
        }

    }

    private static void maxSumOfSubArray(int[] input, int k) {

        //Step 1: initialize variable
        int n= input.length;

        //handle corner case
        if (n < k) {
            System.out.println("Array length is less than the subarray size K.");
            return;
        }


        int sum=0;

        // initialize the boundary of 1st window with size of 'k' element
        int l=0, r=k-1;

        //Step 2:  calculate the sum of 1st window with size k
        for(int i=0; i<=r; i++){
            sum+=input[i];
        }

        //Step 3: initialize the result with sum of 1st 'k' element
        int maxSum= sum;

        //Step 4: slide the window over the array
        while(r<n-1){

            //Step 5:
            sum= sum- input[l]; // Subtract the element going out of the window
            l++;                // Move the left boundary of the window to the right

            r++;                // Expend the right boundary of the window to include new element
            sum=sum+input[r];   // Add the new element coming into the window

            maxSum = Math.max(sum,maxSum); // Update the maximum sum if needed

        }
        System.out.println("MAX SUM : "+maxSum);
    }
}
