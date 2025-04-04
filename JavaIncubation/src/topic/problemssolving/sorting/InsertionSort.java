package topic.problemssolving.sorting;

/**
 * Take an element from unsorted array and place it in its correct position in sorted side<br>
 * Divide virtually an array into 2 part i.e. sorted and unsorted<br>
 * Step : [4,3,2,1]<br><br>
 * 1) Start a loop from o to end of the array<br>
 * 2) Assume 1st element of the array as Sorted and remaining is unsorted. [4],[3,2,1]<br>
 * 3) take 1st element from unsorted array i.e. 2nd element from array in temp to compare it with sorted one<br>
 * 4) temp =[3]<br>
 * 5) Now run another while loop <b>(know as pass)</b> in sorted array from right to left to compare temp<br>
 * 6) if(rightmost element from the loop is > team)<br>
 * 7) right shift that element<br>
 * 8) after completion of the while loop you will reach to correct place where temp need to place<br>
 *
 */
public class InsertionSort {

    private final int[] inputArray;

    public InsertionSort(int[] inputArray) {
        this.inputArray = inputArray;
    }

    /**
     * Time Complexity Best: O(N) for Sorted array as it will not reach out to while loop <br>
     * Average and Worst O(N2)  <br>
     * @return sorted array
     */
    public int[] sort() {

        for(int i=1; i<inputArray.length; i++ ){

            int temp=inputArray[i];
            int j=i-1;

            while (j>=0 && inputArray[j]>temp){
                inputArray[j+1]=inputArray[j];
                j--;
            }
            inputArray[j+1] = temp;
        }
        return inputArray;
    }
}
