package topic.problemssolving.sorting;

import java.util.Arrays;

/**
 * Selection Sort :
 * 1) Select the minimum from entire Array and swap it with 1st element.
 * 2)
 * <br><br>
 * Reference https://www.geeksforgeeks.org/selection-sort-algorithm-2/<br>
 * It requires less number of swaps (or memory writes) compared to other standard alg.<br>
 * Only cycle sort beats it in terms of memory writes.<br>
 * Therefore it can be simple algorithm choice when memory writes are costly.<br>
 * Does not maintain the relative order of equal elements which means it is not stable.
 */
public class SelectionSort {

    private final int[] inputArray;

    public SelectionSort(int[] inputArray) {
        this.inputArray = inputArray;
        System.out.println("input: "+ Arrays.toString(inputArray));
    }

    /**
     * @return sorted inputArray<br>
     * time complexity best, average,worst = O(n2)<br>
     * space complexity = O(1)<br>
     */
    int[] sort(){
        int length=this.inputArray.length;

        for(int i=0;i<=length-2;i++){

            // assume current position holds minimum element
            int mix_idx= i;

            //iterate until reach to the end of the array
            // to find the actual minimum
            for(int j=i+1;j<=length-1;j++){

                // update min_idx if found element
                if(this.inputArray[j]<this.inputArray[mix_idx]){
                    mix_idx = j;
                }

            }
            // movie minimum element at its correct position
            int temp = this.inputArray[i];
            this.inputArray[i] = this.inputArray[mix_idx];
            this.inputArray[mix_idx] = temp;

        }

        return this.inputArray;
    }
}
