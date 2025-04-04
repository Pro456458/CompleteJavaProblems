package topic.problemssolving.commonproblems;

/**
 * Second Largest Element in an Array<br>
 * Given an array of positive integers arr[] of size n, the task is to find second largest distinct element in the array.<br><br>
 * Note: If the second largest element does not exist, return -1.<br><br>
 * Examples:<br><br>
 * Input: arr[] = [12, 35, 1, 10, 34, 1]<br>
 * Output: 34<br>
 * Explanation: The largest element of the array is 35 and the second largest element is 34.<br><br>
 * Input: arr[] = [10, 5, 10]<br>
 * Output: 5<br>
 * Explanation: The largest element of the array is 10 and the second largest element is 5.<br><br>
 * Input: arr[] = [10, 10, 10]<br>
 * Output: -1<br>
 * Explanation: The largest element of the array is 10 there is no second largest element.<br><br>
 */
public class SecondLargestElement {
    public static void main(String[] args) {

        int[] inputArray1={12, 35, 1, 10, 34, 1};
        int[] inputArray2={10, 5, 10};
        int[] inputArray3={10, 10, 10};
        int[] inputArray4={10};

        System.out.println(getSecondLargestElement(inputArray1));
        System.out.println(getSecondLargestElement(inputArray2));
        System.out.println(getSecondLargestElement(inputArray3));
        System.out.println(getSecondLargestElement(inputArray4));

    }

    /**
     * Complexity: <br>
     * Time O(N) <br>
     * Space O(1) as no extra space required <br>
     */
    private static int getSecondLargestElement(int[] inputArray) {

        int fst=Integer.MIN_VALUE;
        int sec= Integer.MIN_VALUE;

        for(int i=0; i<inputArray.length;i++){
            int x = inputArray[i];

            if(x>fst){
                sec=fst;
                fst=x;
            }else if(x>sec && x<fst){
                sec=x;
            }
        }

        if(sec==Integer.MIN_VALUE)
            return -1;

        return sec;
    }

}
