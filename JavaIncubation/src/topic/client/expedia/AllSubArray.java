package topic.client.expedia;

import java.util.Arrays;
import java.util.List;

public class AllSubArray {
    public static void main(String[] args) {

        List<int[]> inputs = List.of(
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9},
                new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1},
                new int[]{2, 3, -8, 7, -1, 2, 3}
        );

        for(int[] input : inputs){
            System.out.println("Inputs:"+ Arrays.toString(input));
            printAllSubArraySumBrutForceSearch(input);
            System.out.println("=====================================");
        }
    }

    private static void printAllSubArraySumBrutForceSearch(int[] input) {
        int n = input.length;
        int maxSum=0;
        for(int i=0 ; i<=n-1 ; i++){

            int currSum=0;

            for(int j=i ; j<=n-1 ; j++){
                currSum+=input[j];
                System.out.print(input[j]+",");
            }

            maxSum=Math.max(currSum,maxSum);

            System.out.println("Curr=>"+currSum+", Max=>"+maxSum);

        }
    }
}
