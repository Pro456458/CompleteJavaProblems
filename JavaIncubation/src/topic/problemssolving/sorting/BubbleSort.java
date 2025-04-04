package topic.problemssolving.sorting;

import java.util.Arrays;

/**
 * Bubble Sort :<br>
 * Push the maximum to last by <b>adjacent swapping</b> i.e. opposite to the Selection Sort<br>
 * Bubble sort with optimized version takes minimum time (Order of n) when elements are already sorted. <br>
 * Hence it is best to check if the array is already sorted or not beforehand, <br>
 * to avoid O(n2) time complexity.<br>
 */
public class BubbleSort {

    private final int[] inputArray;

    public
    BubbleSort(int[] inputArray) {
        this.inputArray = inputArray;
        System.out.println("input: "+ Arrays.toString(inputArray));
    }

    /**
     * In Case Of Any Array
     * Time Complexity : Best,Average and Worst O(N2)
     * @return modified array
     */
    public int[] sortWithoutOptimization() {
        int n=inputArray.length;

        for(int i=n-1; i>0; i--){

            for(int j=0; j<i; j++){

                if(inputArray[j]>inputArray[j+1]) {
                  int temp = inputArray[j+1];
                  inputArray[j+1] = inputArray[j];
                  inputArray[j] = temp;
              }

            }

        }

        return inputArray;

    }

    /**
     * In Case Of Sorted Array
     * Time Complexity : in Best Case O(N) , Average and Worst O(N2)
     * @return modified array
     */
    public int[] sortWithOptimization() {
        int n=inputArray.length;
        boolean swapped=false;
        for(int i=n-1; i>0; i--){

            for(int j=0; j<i; j++){

                if(inputArray[j]>inputArray[j+1]) {
                    int temp = inputArray[j+1];
                    inputArray[j+1] = inputArray[j];
                    inputArray[j] = temp;
                    swapped=true;
                }

            }
            // if no swapped by inner loop then break
            // array is already sort
            if (!swapped)
                break;
        }

        return inputArray;

    }
}
