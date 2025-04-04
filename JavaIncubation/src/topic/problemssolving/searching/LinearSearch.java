package topic.problemssolving.searching;

import topic.problemssolving.sorting.QuickSort;

import java.util.Arrays;

public class LinearSearch {

    /**
     Time Complexity:

     Best Case: key might be present at the first index. O(1)
     Worst Case: key might be present at the last index O(N)
     Average Case: O(N)
     */
    public static int linearSearch(int[] intArray, int searchElement) {
        for(int i = 0; i< intArray.length; i++){
            if(intArray[i]== searchElement){
                return i;
            }
        }
        return -1;
    }


}
