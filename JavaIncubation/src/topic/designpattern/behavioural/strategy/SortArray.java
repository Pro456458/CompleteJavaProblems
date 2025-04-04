package topic.designpattern.behavioural.strategy;



public class SortArray {

    private SortingStrategy sortingStrategy;

    public void setSortingStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void sortArray(int[] input){
        sortingStrategy.sort(input);
    }


}

