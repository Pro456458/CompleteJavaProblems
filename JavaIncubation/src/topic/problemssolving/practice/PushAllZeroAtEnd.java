package topic.problemssolving.practice;

import java.util.Arrays;

public class PushAllZeroAtEnd {

    public static void main(String[] args) {

        int[] inputArray1={1, 2, 0, 4, 3, 0, 5, 0};
        int[] inputArray2={10, 20, 30};
        int[] inputArray3={0,0};

        System.out.println(Arrays.toString(moveAllZeroToEnd(inputArray1)));
        System.out.println(Arrays.toString(moveAllZeroToEnd(inputArray2)));
        System.out.println(Arrays.toString(moveAllZeroToEnd(inputArray3)));

    }

    private static int[] moveAllZeroToEnd(int[] arr) {

        int count=0;

        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0) {
                int temp=arr[i];
                arr[i] = arr[count];
                arr[count]=arr[i];
                count++;
            }

        }

        return arr;
    }


}
