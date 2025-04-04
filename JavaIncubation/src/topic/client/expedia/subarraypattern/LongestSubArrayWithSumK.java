package topic.client.expedia.subarraypattern;

import java.util.Arrays;
import java.util.List;

public class LongestSubArrayWithSumK {

    public static void main(String[] args) {
        List<int[]> inputs = List.of(
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9},
                new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1},
                new int[]{2, 1, 5, 1, 3, 2},
                new int[]{2, 3, -8, 7, -1, 2, 3}
        );
        int k=24;
        for(int[] input : inputs){
            System.out.println("Inputs:"+ Arrays.toString(input));
            longestSubArrayWithSumKBruteForceMethod(input,k);
            longestSubArrayWithSumKOptimizedMethod(input,k);
        }

    }

    /**
     * Time complexity : O(N^2)
     */
    private static void longestSubArrayWithSumKBruteForceMethod(int[] input, int k) {

        int n= input.length;
        int loop=0;
        int maxLength=0;

        for(int i=0; i<=n-1;i++){
            int sum =0;
            for(int j=i; j<=n-1; j++){
                loop++;
                sum+=input[j];
                if(sum<=k)
                    maxLength = Math.max(maxLength, j-i+1);
                //we can optimize the time by addind below condition
                else if (sum>k)
                    break;

            }

        }
        System.out.println("loop iterate:"+(loop));
        System.out.println("Max Sub Array length for sum: "+k+" is "+maxLength);

    }


    private static void longestSubArrayWithSumKOptimizedMethod(int[] input, int k) {

        int n=input.length;
        int l=0, r=0, sum=0, maxLength=0;
        int loop=0;
        for( int i=0; i<=n-1; i++){

            while(r<=n-1){

                sum= sum+input[r];
                loop++;
                while(sum>=k){
                    sum = sum - input[l];
                    l++;
                    loop++;
                }

                if(sum<=k) {
                    maxLength = Math.max(maxLength, (r - l + 1));
                    //place to store the sub array
                }
                r++;
            }
        }

        System.out.println("loop iterate:"+(loop));
        System.out.println("Max Sub Array length for sum: "+k+" is "+maxLength);

    }

}
