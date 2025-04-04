package topic.client.expedia;


import java.util.Arrays;
import java.util.List;

/**
 * Problem: Given an array arr[], <br>
 * the task is to find the sub-array that <br>
 * has the maximum sum and return its sum. 4 <br>
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
            System.out.println("Find Max Sum of Sub-Array with length:"+k);
            System.out.println("===>Sum of Max Sub Array: "+findMaxSumOFSubArray(input , k ));
        }

    }

    private static int findMaxSumOFSubArray(int[] arr, int k) {

        //Step 1: initialize variable
        int n = arr.length;
        int sum =0;
        //boundary of 1st window with size of 'k' element



        //Step 2: Calculate the sum of 1st 'k' element
        System.out.print("[");
        for(int i=0; i<=k-1; i++){        // in the condition you can use i<=r OR i<=k-1
            sum+=arr[i];
            System.out.print(arr[i]+",");
        }
        System.out.println("] -> "+sum+" is the sum of 1st subArray with size: "+ k);



        //Step 3: initialize the result with sum of 1st 'k' element
        int maxSum = sum;



        //Step 4: slide the window over the array
        for (int i=k; i<n; i++){

            //Step 5: add the new element coming into the window
            //        and
            //        subtract the element going out of the window
            sum= sum+arr[i]-arr[i-k];

            System.out.println("sum of next subArray: "+sum);

            //Step 6: Update the result (this part varies based on the problem)
            if(sum>maxSum)
                maxSum=sum;

        }

        return maxSum;

    }
}
