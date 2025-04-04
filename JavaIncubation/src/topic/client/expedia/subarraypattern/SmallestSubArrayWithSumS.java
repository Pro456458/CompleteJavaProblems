package topic.client.expedia.subarraypattern;

import java.util.Arrays;
import java.util.List;

public class SmallestSubArrayWithSumS {

     public static void main (String[]args){
            List<int[]> inputs = List.of(
                    new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9},
                    new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1},
                    new int[]{2, 1, 5, 1, 3, 2},
                    new int[]{2, 3, -8, 7, -1, 2, 3}
            );
            int s = 15;
            for (int[] input : inputs) {
                System.out.println("Inputs:" + Arrays.toString(input));
                smallestSubArrayWithSumKBruteForceMethod(input, s);
                smallestSubArrayWithSumKOptimizedMethod(input, s);
            }

     }

    private static void smallestSubArrayWithSumKBruteForceMethod(int[] input, int s) {
    }

    private static void smallestSubArrayWithSumKOptimizedMethod(int[] input, int s) {

         int n = input.length;

         int l=0 , r =0, sum=0, minLength=Integer.MAX_VALUE;


         for(int i=0; i<=n-1; i++){

             while(r<n){

                 sum = sum + input[r];

                 while(sum>=s){
                     minLength = Math.min(minLength, r-l+1);
                     sum = sum - input[l];
                     l++;
                 }

                 r++;
             }

         }
        if(minLength == Integer.MAX_VALUE)
            System.out.println("No subarray with sum >= " + s);
        else
            System.out.println("Smallest Subarray length with sum >= " + s + " is " + minLength);





    }
}