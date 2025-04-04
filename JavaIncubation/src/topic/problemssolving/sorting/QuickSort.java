package topic.problemssolving.sorting;

import java.util.Arrays;

/**
 * Best Case : (n log n)
 * Average Case : (n log n)
 * Worst Case: (O(n²))
 * Space Complexity: O(log n), for the temporary array used during merging
 */
public class QuickSort {


    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};

        System.out.println("input Array");
        System.out.println(Arrays.toString(arr));
        int n = arr.length;

        int[] outputArr=quickSort(arr, 0, n - 1);
        System.out.println("sorted array");
        System.out.println(Arrays.toString(outputArr));
    }

    public static int[] quickSort(int[] arr, int low, int high) {
        if(low<high){

            // pi is the partition return index of the pivot
            int pi = partition(arr,low,high);

            quickSort(arr,low,pi-1);
            quickSort(arr,pi+1,high);

        }
        return arr;
    }

    private static int partition(int[] arr, int low, int high) {

        //choose the pivot
        int pivot = arr[high];

        // Index of smaller element and indicates
        // the right position of pivot found so far
        int i = low - 1;


        // Traverse arr[low..high] and move all smaller
        // elements to the left side. Elements from low to
        // i are smaller after every iteration
        for(int j=low;j<= high-1;j++){
            if(arr[j]<pivot){
                i++;
                swap(arr,i,j);
            }
        }

        // Move pivot after smaller elements and
        // return its position
        swap(arr, i + 1, high);
        return i + 1;
    }

    // Swap function
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
