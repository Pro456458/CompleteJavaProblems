package topic.designpattern.behavioural.strategy;

import java.util.Arrays;

public class MergeSort implements SortingStrategy{
    @Override
    public int[] sort(int[] inputArray) {

        int[] tempArray = Arrays.copyOf(inputArray,inputArray.length);

        sort(tempArray,0,tempArray.length-1);
        System.out.println("Array Sort using Merge Sort : "+ Arrays.toString(tempArray));
        return tempArray;
    }

    /**
     * Find the middle of input-array from where it will further<br>
     * divide into 2 part and again call itself recursively until l < r<br>
     * then call merge method to re join the sub array after compression<br>
     */
    private void sort(int[] inputArray, int l, int r) {
        if(l<r){

            int mid = l+(r-l)/2;

            sort(inputArray,l,mid);
            sort(inputArray,mid+1,r);

            merge(inputArray,l,mid,r);
        }
    }

    /**
     * find the size of sub arrays (need clarity)<br>
     * create 2 sub array<br>
     * copy element from main array to sub arrays (index while copy)<br>
     * now compare element from sub array and merge into main array<br>
     *
     */
    public void merge(int[] inputArray, int l, int m, int r){

        int n1 = m-l+1;
        int n2 = r-m;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for(int i=0;i<n1;i++){
            left[i]=inputArray[l+i];
        }

        for(int j=0;j<n2;j++){
            right[j]=inputArray[m+1+j];
        }


        int i=0;
        int j=0;

        int k=l;

        while(i<n1 && j<n2){

            if(left[i]<right[j]) {
                inputArray[k] = left[i];
                i++;
            }else{
                inputArray[k] = right[j];
                j++;
            }
            k++;
        }

        while (i<n1){
            inputArray[k] = left[i];
            i++;
            k++;
        }

        while(j<n2){
            inputArray[k] = right[j];
            j++;
            k++;
        }

    }
}
