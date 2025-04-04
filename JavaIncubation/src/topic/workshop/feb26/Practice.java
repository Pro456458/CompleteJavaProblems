package topic.workshop.feb26;

import java.util.Arrays;

public class Practice {
    public static void main(String[] args) {

        sortingAlgoPractice();
        printEvenOddNumberUsingThread();
    }

    private static void printEvenOddNumberUsingThread() {
        PrintOddEvenNoUsingThreads.main(new String[]{"50"});
    }


    private static void sortingAlgoPractice() {

        mergeSort(new int[] {38, 27, 43, 10});
        quickSort(new int[] {38, 27, 43, 10});

    }

    /**
     * Merge Sort Work on divide and concur technique <br>
     * Step :<br>
     * 1) divide the main array from <b>mid</b> into sub array from its mid until each sub-array contains only one element.<br>
     * 2) concur sub array back to main array after doing comparison<br><br>
     *
     * Step to pay attention<br>
     * 1) while finding mid<br>
     * 2) while finding length of sub array<br>
     * 3) understanding of index range while copying value from main array to sub array
     */
    private static void mergeSort(int[] input) {

        System.out.println("Unsorted Array:"+Arrays.toString(input));
        int l=0;
        int r= input.length-1;
        divide(input,l,r);
        System.out.println("Sorted Array :"+Arrays.toString(input));
    }

    private static void divide(int[] input, int l, int r) {

        if(l<r) {
            int mid = l+(r-l)/2;

            divide(input,l,mid);
            divide(input,mid+1,r);

            concur(input,l,mid,r);
        }

    }

    private static void concur(int[] input, int l, int mid, int r) {

        //find the length of sub array
        int n1 = mid-l+1;
        int n2 = r-mid;

        //create sub arrays
        int[] left = new int[n1];
        int[] right = new int[n2];


        // copy value from main array to sub array

        for(int i=0;i<n1;i++){
            left[i] = input[l+i];       //left sub array start from l
        }
        //System.arraycopy(input, l + 0, left, 0, n1);

        for(int j=0; j<n2;j++){
            right[j] = input[mid+1+j];  // right sub array start from mid+1
        }
        //System.arraycopy(input, mid + 0, right , 0 , n2);


        //concur sub arrays back to main array after comparison
        int i=0;
        int j=0;
        int k=l;

        while(i<n1 && j<n2){

            if(left[i]<=right[j]){
                input[k] = left[i];
                i++;
            }else{
                input[k] = right[j];
                j++;
            }
            k++;
        }


        // concur remaining element from sub array into main array

        while(i<n1){
            input[k] = left[i];
            i++;k++;
        }
        while(j<n2){
            input[k] = right[j];
            j++;k++;
        }

    }



    private static void quickSort(int[] ints) {

    }

}
