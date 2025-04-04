package topic.client.expedia.subarraypattern;

import java.util.Arrays;
import java.util.List;

public class SubArray {

    public static void main(String[] args) {

        List<int[]> inputs = List.of(
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9},
                new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1},
                new int[]{2, 3, -8, 7, -1, 2, 3}
        );

        for(int[] input : inputs){
            System.out.println("Inputs:"+ Arrays.toString(input));
            subArrayUsingBruteForceMethod(input);
        }

    }

    /**
     * Time Complexity :  (n*n*n) = O(n^3) <br>
     * Explanation: <br>
     * The outer loop runs from the start of the array to the end.<br>
     * The inner loop runs from the current position of the outer loop to the end.<br>
     * A third loop (or a method call) is used to print or process the sub-array.<br>
     *
     */
    private static void subArrayUsingBruteForceMethod(int[] input) {

        int n= input.length;

        for(int i=0; i<=n-1;i++){

            for(int j=i; j<=n-1;j++){
                System.out.print("=>[");
                for(int k=i; k<=j; k++){
                    System.out.print(input[k]+" ");
                }
                System.out.println("]");


            }


        }
    }
}
