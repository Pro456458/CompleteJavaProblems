package topic.client.expedia.subarraypattern;

import java.util.*;

public class SumOfSubArray {
    public static void main(String[] args) {
        List<int[]> inputs = List.of(
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9},
                new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1},
                new int[]{2, 3, -8, 7, -1, 2, 3}
        );

        for(int[] input : inputs){
            System.out.println("Inputs:"+ Arrays.toString(input));
            //Map<Integer, int[]> integerMap = sumOfSubArray(input);
            optimizeSumOfSubArray(input);
            System.out.println("===>Sum of Sub Array:");
            //integerMap.forEach((k,v) -> System.out.println("Sub Array:"+Arrays.toString(v)+", Sum:"+k));
        }
    }

    /**
     * Time Complexity : 1st loop run :n time , 2 loop run :i time for each iteration <br>
     * n(n+1)/2 i.e. O(n^2)
     */
    private static Map<Integer,int[]> sumOfSubArray(int[] input) {

        int n=input.length;

        //taken additional variable to store and print all sub-array and its sum, outside this method
        Map<Integer,int[]> subArrayWithSum = new LinkedHashMap<>();

        for(int i=0; i<=n-1; i++){

            int currentSum=0;

            //additional variable to store the sub array
            int[] subArray=new int[i+1];
            int k=0;

            for(int j=0; j<=i; j++){
                currentSum+=input[j];

                //addition task to store the sub array
                subArray[k]=input[j];
                k++;
            }
            subArrayWithSum.put(currentSum,subArray);
        }
        return subArrayWithSum;
    }

    private static Map<Integer,int[]> optimizeSumOfSubArray(int[] input){
        int n=input.length;

        //taken additional variable to store and print all sub-array and its sum, outside this method
        Map<Integer,int[]> subArrayWithSum = new LinkedHashMap<>();
        int currentSum=0;
        for(int i=0;i<n-1;i++){
            currentSum= currentSum + input[i];
            System.out.println("currentSum: of "+(i+1)+" sub array :"+currentSum);
        }


        return null;


    }
}
