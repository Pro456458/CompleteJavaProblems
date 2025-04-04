package topic.client.expedia.coupons;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class TestCustomIterator {

    public static void main(String[] args) {


        List<Integer> integerList = List.of(1,2,3,4,5,6,7,8,9,10);


        ListIterator iterator = new ListIterator(integerList);

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }



}


class ListIterator implements Iterator<Integer>{

    private AlternateIterator<Integer> alternateIterator;
    private int index;
    private List<Integer> integerList;

    public ListIterator(List<Integer> integerList) {

        this.integerList = integerList;

        alternateIterator = (intList,idx) ->{
            if(idx<intList.size()) {
                return intList.get(idx);
            }
            return null;
        };
    }

    @Override
    public Integer next() {

        if(!hasNext())
            throw new NoSuchElementException("No more alternative Element");

        int value;

        value=alternateIterator.next(integerList,index);
        index+=2; // move 2

        return value;
    }

    @Override
    public boolean hasNext() {
        return index<integerList.size();
    }

    public AlternateIterator<Integer> getIterator() {
        return alternateIterator;
    }

    public void setIterator(AlternateIterator<Integer> alternateIterator) {
        this.alternateIterator = alternateIterator;
    }
}



@FunctionalInterface
interface AlternateIterator<T>{
    T next(List<T> list, int index);
}