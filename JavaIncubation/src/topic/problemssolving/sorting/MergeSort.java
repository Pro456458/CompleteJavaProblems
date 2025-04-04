package topic.problemssolving.sorting;

import java.util.Arrays;

/**
 * Time Complexity: (O(logN) : for divide , O(n) : merge) => O(N logN) <br>
 * Best Case: O(n log n), sorted or nearly sorted array.<br>
 * Average Case: O(n log n), array is randomly ordered.<br>
 * Worst Case: O(n log n), array is sorted in reverse order.<br>
 * Space Complexity: O(n), for the temporary array used during merging.<br>
 */
public class MergeSort {

    public static void main(String[] args) {

        int[] inputArray = {38, 27, 43, 10};
        System.out.println("Input Array");
        System.out.println(Arrays.toString(inputArray));

        int l=0;
        int r=inputArray.length-1;

        sort(inputArray,l,r);
        System.out.println("Sorted Array");
        System.out.println(Arrays.toString(inputArray));

    }

    private static void sort(int[] inputArray, int l, int r) {
        if(l<r){

            // find the mid of inputArray to divide into half
            int m= l+(r-l)/2;

            //sort both subArray
            sort(inputArray,l,m);
            sort(inputArray,m+1,r);

            merge(inputArray,l,m,r);

        }

    }

    private static void merge(int[] inputArray, int l, int m, int r) {

        // find the size of sub arrays
        int n1 = m-l+1;
        int n2 = r-m;

        //create temp array i.e. sub array  to hold value from inputArray
        int[] left = new int[n1];
        int[] right = new int[n2];

        //copy value from inputArray into temp array i.e. sub array

        //left sub array
        for(int i=0; i< n1; i++){
            left[i] = inputArray[l+i];   //left sub array start from l
        }
        //right sub array
        for(int j=0; j< n2; j++){
            right[j] = inputArray[m+1+j]; // right sub array start from mid+1
        }

        //merge temp array i.e. sub arrays after comparison
        int i=0;
        int j=0;

        //initialize index of merged sub array
        int k=l;

        while(i<n1 && j<n2){

            if(left[i] <= right[j]){
                inputArray[k] = left[i];
                i++;
            }else{
                inputArray[k] = right[j];
                j++;
            }
            k++;
        }

        //copy remaining array of element if any
        while(i<n1){
            inputArray[k]=left[i];
            i++;
            k++;
        }
        while(j<n2){
            inputArray[k]=right[j];
            j++;
            k++;
        }

    }

}
