package topic.workshop.march28;

import java.util.Arrays;
import java.util.Map;

public class Practice {
    public static void main(String[] args) {

        //Problem: find the start and end index of the continuous
        // unsorted sub-array within a partially sorted array in Java.

        //such that if you only sort this sub-array in non-decreasing order,
        // then the whole array will be sorted in non-decreasing order.


        Map<Integer[],Integer[]> inputArrayWithOutput =  Map.of(
                new Integer[]{2, 6, 4, 8, 10, 9, 15},new Integer[]{1,5},
                new Integer[]{1, 3, 5, 2, 6, 4, 8, 10},new Integer[]{2,5},
                new Integer[]{10, 12, 5, 6, 15, 20, 30},new Integer[]{0,3},
                new Integer[]{1, 2, 3, 4, 5, 10, 9, 8, 7, 6},new Integer[]{5,9});


        inputArrayWithOutput.forEach((k,v) ->
        {

            System.out.println("find the start and end index of the continuous \n" +
                    "unsorted sub-array within a partially sorted array in Java :\n"+
                    Arrays.toString(k));

            Integer[] subArrayIndexes= findContinuousSubArray(k);

            System.out.println("result : "+Arrays.equals(v,subArrayIndexes) +"\n"+
                    "excepted :"+Arrays.toString(v)+
                    " , actual   :"+Arrays.toString(subArrayIndexes));

            System.out.println("==========================");
        });



    }

    private static Integer[] findContinuousSubArray(Integer[] numbs) {

        int l = 0;
        int r = numbs.length-1;

        int start = -1; int end = -1;

        //Step 1 : find the 1st index which is out of order from left
        for(int i=l ; i<=r ;i++){
            if(numbs[i] > numbs[i+1]) {
                start = i;
                break;
            }
        }

        // if the array is already sorted
        if(start==-1)
            return new Integer[]{-1,-1};

        //Step 2 : find the 1st index which is out of order from right
        for(int j=r ; j>=l ;j--){
            if(numbs[j] < numbs[j-1]) {
                end = j;
                break;
            }
        }


        //Step 3 : find the minimum and maximum in sub array
        int minValue=Integer.MAX_VALUE;  int maxValue = Integer.MIN_VALUE;

        for(int i=start ; i<end ;i++){
            minValue=Math.min(numbs[i],numbs[i+1]);
            maxValue=Math.max(numbs[i],numbs[i+1]);
        }

        //Step 4 : expend the start index to the left window of sub-array to
        // include any element to the left of the identified start index that are greater than minimum value

        for(int i=l; i<=start ; i++){
            if(numbs[i] > minValue )
                start = i;
        }

        // step 5 : expend the end index to the right window of sub-array to
        // include any element to the right of the identified end index that are smaller than maximum value
        for(int j=r; j>=end ; j--){
            if(numbs[j]<maxValue)
                end = j;
        }

        return new Integer[]{start,end};

    }
}
