package topic.problemssolving.sorting;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] sortedArray=null;

        SelectionSort selectionSort = new SelectionSort(new int[] {15,10,8,3});
        sortedArray = selectionSort.sort();
        System.out.println("Sorted Array After Selection Sort");
        System.out.println(Arrays.toString(sortedArray));
        System.out.println("X==========XX===========X");

        BubbleSort bubbleSort = new BubbleSort(new int[] {12,6,9,3});
        sortedArray = bubbleSort.sortWithoutOptimization();
        System.out.println("Sorted Array After Bubble Sort");
        System.out.println(Arrays.toString(sortedArray));
        System.out.println("X==========XX===========X");

        bubbleSort = new BubbleSort(new int[]{1,2,3,4,5});
        sortedArray = bubbleSort.sortWithOptimization();
        System.out.println("Sorted Array After Optimize Bubble Sort");
        System.out.println(Arrays.toString(sortedArray));
        System.out.println("X==========XX===========X");

        InsertionSort insertionSort = new InsertionSort(new int[] {12,6,9,3});
        sortedArray = insertionSort.sort();
        System.out.println("Sorted Array After Insertion Sort");
        System.out.println(Arrays.toString(sortedArray));
        System.out.println("X==========XX===========X");

        System.out.println("Sorted Array After Quick Sort");
        QuickSort.main(new String[]{""});
        System.out.println("X==========XX===========X");

    }

}