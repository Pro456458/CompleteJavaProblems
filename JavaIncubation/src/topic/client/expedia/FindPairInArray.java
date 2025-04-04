package topic.client.expedia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * problem : <br>
 * Find the pair of array elements which sum are equals to target.<br>
 * Note: same element should not be added<br>
 *   input = {5, 2, 11, 2, -1, 3};<br>
 *   target = 10;<br>
 *   expected output = [11,-1]<br>
 * Approach:<br>
 * Sort the Array and then use two pointer technique<br><br>
 *
 * Initialization:<br><br>
 *
 * Two pointers are initialized: left at the beginning of the array and right at the end.<br>
 * Iterative Process:<br>
 *
 * The while loop while (left < right) ensures that the pointers do not cross each other.<br>
 * Calculating the Sum:<br><br>
 *
 * Inside the loop, the sum of the elements at the left and right pointers is calculated: int sum = array[left] + array[right];.<br>
 * Comparison with Target:<br><br>
 *
 * If the calculated sum equals the target, the pair is found, and the function returns the pair.<br>
 * If the sum is less than the target, it means the current pair's sum is too small. To increase the sum, the left pointer is moved to the right (left++), which brings in a larger element (since the array is sorted).<br>
 * If the sum is greater than the target, it means the current pair's sum is too large. To decrease the sum, the right pointer is moved to the left (right--), which brings in a smaller element.<br>
 * time complexity : O(n log n ) for sorting <br>
 */
public class FindPairInArray {

    public static void main(String[] args) {

        int target = 10;
        int[] inputArray = {5, 2, 11, 2, -1, 3};
        List<int[]> pairs = findPairUsingTwoPointer(inputArray,target);

        if(pairs.isEmpty())
            System.out.println("No Pair Found");
        else
            pairs.forEach(arr-> System.out.println(Arrays.toString(arr)));

    }

    private static List<int[]> findPairUsingBruteForce(int[] inputArray, int target){

        List<int[]> pairs= new ArrayList<>();
        int n=inputArray.length;

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n-1;j++) {
                if (inputArray[i] + inputArray[j] == target) {
                    pairs.add(new int[]{inputArray[i], inputArray[j]});
                }
            }
        }

        return pairs;
    }

    private static List<int[]> findPairUsingTwoPointer(int[] input, int target){

        List<int[]> pairs = new ArrayList();

        Arrays.sort(input);

        int left=0;int right=input.length-1;

        while(left<right){

            int sum =input[left]+input[right];

            if(sum==target){
                pairs.add(new int[]{input[left],input[right]});
                break;
            }else if(sum < target) {
                left++;
            }else{
                right--;
            }
        }

        return pairs;
    }




}
