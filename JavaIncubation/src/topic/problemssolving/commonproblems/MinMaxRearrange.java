package topic.problemssolving.commonproblems;

import java.util.Arrays;

/**
 * Given a sorted array of positive integers, rearrange the array alternately i.e first element should be a maximum value, at second position minimum value, at third position second max, at fourth position second min, and so on.<br> <br>
 * Examples: <br><br>
 * Input: arr[] = {1, 2, 3, 4, 5, 6, 7}<br>
 * Output: arr[] = {7, 1, 6, 2, 5, 3, 4}<br>
 * Explanation: First 7 is the max value, then 1 is the min value, then 6 is the second max value, then 2 is the second min value, then 5 is the third max value, then 3 is the third min value and at last 4 is the fourth max value.<br><br>
 * Input: arr[] = {1, 2, 3, 4, 5, 6}<br>
 * Output: arr[] = {6, 1, 5, 2, 4, 3}<br>
 */
public class MinMaxRearrange {

    public static void main(String[] args) {

        int[] inputArray1={1, 2, 3, 4, 5, 6, 7};
        int[] inputArray2={1, 2, 3, 4, 5, 6};

        System.out.println(Arrays.toString(minMaxRearrange(inputArray1)));
        System.out.println(Arrays.toString(minMaxRearrange(inputArray2)));

    }

    private static int[] minMaxRearrange(int[] inputArray) {

        int n=inputArray.length-1;
        int i=0;int j=n;
        int k=0;
        int[] modifiedArray=new int[n+1];

        for(; i<j; i++,j--){
            modifiedArray[k++]=inputArray[j];
            modifiedArray[k++]=inputArray[i];
        }

        if((inputArray.length%2)!=0)
            modifiedArray[k]=inputArray[i];

        return  modifiedArray;
    }
}
