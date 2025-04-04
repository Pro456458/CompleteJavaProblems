package topic.client.expedia.subarraypattern.subarraywithgivensum;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Problem: Find a sub-array with a given sum S
 */
public class SubArrayWithGivenSum {

    public static void main(String[] args) {
        List<int[]> inputs = List.of(
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9},
                new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1},
                new int[]{2, 1, 5, 1, 3, 2},
                new int[]{2, 3, -8, 7, -1, 2, 3}
        );
        int S=6;
        for(int[] input : inputs){
            System.out.println("Inputs:"+ Arrays.toString(input));
            subArrayWithGivenSum(input,S);
        }


    }

    private static void subArrayWithGivenSum(int[] arr, int targetSum) {

        int n=arr.length;
        int l=0, r=0;
        int currentSum=0;
        int result = 0;  // This will store the result based on the specific problem

        List<int[]> subArrays= new LinkedList<>();



        // Iterate through the array with the end pointer
        while(r<n){

            // Add the current element to the current sum
            currentSum = currentSum + arr[r];

            // Adjust the window size if the current sum exceeds the target sum
            while(currentSum>targetSum && l<r){
                currentSum = currentSum - arr[l];
                l++;
            }

            // Apply the main logic based on the specific problem
            if(currentSum==targetSum) {
                // Update the result based on the specific problem

                // Example: Count the subarrays
                result++;  // For counting subarrays with the given sum

                //Example: Find all sub-array with a given sum S
                subArrays.add(new int[]{l,r});

                //Example: Find 1st sub-array with a given sum S
                //break;

                // Example: Update the maximum length of sub-array
                // initialized result with Integer.MIN_VALUE
                // result = Math.max(result, r - l + 1);  // For longest sub-array with the given sum

                // Example: Update the minimum length of sub-array
                // initialized result with Integer.MAX_VALUE
                // result = Math.min(result, r - l + 1);  // For shortest sub-array with the given sum

            }
            r++;

        }



        // Print here or outside
        if(!subArrays.isEmpty()) {
            System.out.println(result + " Sub Array found with given sum:" + targetSum);
            subArrays.forEach(subArray -> {
                System.out.print("[");
                for (int i = subArray[0]; i <= subArray[1]; i++) {
                    System.out.print(arr[i] + ",");
                }
                System.out.println("]");
            });
        }else{
            System.out.println("No sub Array found with given sum:"+targetSum);
        }
        System.out.println("===================================");


    }
}
