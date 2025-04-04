package topic.designpattern.behavioural.strategy;

import java.util.Arrays;

public class TestSortingStrategy {



    public static void main(String[] args) {

        int[] inputArray={15,10,8,3};

        System.out.println(Arrays.toString(inputArray));

        SortArray sortArray = new SortArray();
        sortArray.setSortingStrategy(new MergeSort());
        sortArray.sortArray(inputArray);

        System.out.println(Arrays.toString(inputArray));

        sortArray.setSortingStrategy(new QuickSort());
        sortArray.sortArray(inputArray);

        System.out.println(Arrays.toString(inputArray));

    }

}
