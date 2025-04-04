package topic.problemssolving.searching;

import topic.problemssolving.sorting.QuickSort;

public class BinarySearch {

    /**
     * Time Complexity: O(log N)
     *
     */
    private static int binarySearch(int[] intArray, int searchElement) {

        int high = intArray.length-1;
        int low=0;

        while(low<high){
            int mid = low+(high-low)/2;
            System.out.println(mid);
            //Check if searchElement is present at mid
            if(searchElement == intArray[mid]) {
                return mid;
            }
            //If searchElement is smaller ignore right half
            if(searchElement < intArray[mid]){
                high=mid-1;
            }
            //If searchElement is greater ignore left half
            else {
                low = mid+1;
            }
        }
        return -1;

    }

}
