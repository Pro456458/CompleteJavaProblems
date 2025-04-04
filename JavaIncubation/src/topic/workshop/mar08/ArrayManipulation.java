package topic.workshop.mar08;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayManipulation {

    public static void main(String[] args) {

        ArrayManipulation arrayManipulation = new ArrayManipulation();
        arrayManipulation.findMaximumAndMinimumElementInArray();
        arrayManipulation.findMaximumAndMinimumElementInArrayUsingJava8();
        arrayManipulation.secondLargestAndSmallestElementInArray();
        arrayManipulation.secondLargestAndSmallestElementInArrayUsingJava8();
        arrayManipulation.checkIfArrayIsSorted();


    }

    private void findMaximumAndMinimumElementInArrayUsingJava8() {

        Stream<Integer> integerStream = Arrays.stream(new int[]{2, 4, 4, 0}).boxed();
        Optional<Integer> max=integerStream.max((o1, o2) -> o1.compareTo(o2));
        System.out.println(max.orElse(0));
//========================================================

//        Optional<Integer> max1=integerStream.max(Comparator.naturalOrder());
//        System.out.println(max1.orElse(0));

//========================================================

//        Optional<Integer> max2=integerStream.max(Comparator.comparingInt(value -> value));
//        System.out.println(max2.orElse(0));

//========================================================

//        Optional<Integer> max3=integerStream.collect(Collectors.maxBy(Comparator.naturalOrder()));
//        System.out.println(max3.orElse(0));

//========================================================

//      Comparator<Integer> comparingInt = (o1,o2) ->  o1.compareTo(o2) ;
//        Comparator<Integer> comparingInt = (o1,o2) -> Integer.compare(o1,o2) ;
//        Optional<Integer> max5=integerStream.max(comparingInt);
//        System.out.println(max5.orElse(0));

//========================================================

//        Optional<Integer> max4=integerStream.collect(Collectors.maxBy(Comparator.comparingInt(value -> value)));
//        System.out.println(max4.orElse(0));

//========================================================

    }

    private void checkIfArrayIsSorted() {
        int[] arr={10,13,20,15,60,5,40,18,30,1};
        int n=arr.length-1;

        boolean isSorted=true;

        for(int i=0; i<n ; i++){

            if(arr[i]>arr[i+1]) {
                isSorted = false;
                break;
            }

        }

        System.out.println("Array is Sorted : "+ isSorted);

    }

    private void secondLargestAndSmallestElementInArray() {

        int[] arr={10,13,20,15,60,5,40,18,30,1};
        int n=arr.length-1;

        find2LargestElement(n, arr);
        find2SmallestElement(n,arr);
    }

    private void find2SmallestElement(int n, int[] arr) {
        int firstMin=Integer.MAX_VALUE;
        int secondMin=Integer.MAX_VALUE;

        for(int i = 0; i<= n; i++){

            if(arr[i]<firstMin){
                secondMin=firstMin;
                firstMin= arr[i];
            }

        }
        System.out.println("firstMin :"+firstMin +", secondMin : "+secondMin);
    }

    private void find2LargestElement(int n, int[] arr) {
        int firstMax=Integer.MIN_VALUE;
        int secondMax=Integer.MIN_VALUE;

        for(int i = 0; i<= n; i++){

            if(arr[i]>firstMax){
                secondMax=firstMax;
                firstMax= arr[i];
            }

        }
        System.out.println("firstMax :"+firstMax +", secondMax : "+secondMax);
    }


    private void secondLargestAndSmallestElementInArrayUsingJava8(){
        //find second smallest element

        int[] intArr =new int[]{2, 4, 4, 0};
        List<Integer> intList=Arrays.stream(intArr).sorted().boxed().collect(Collectors.toList());
        System.out.println(intList);

        System.out.println(intList.stream().skip(1).findFirst().get());

        //find second largest element

        Integer[] integerArr ={2, 4, 4, 0};
        List<Integer> sorted = Arrays.stream(integerArr).sorted(Comparator.reverseOrder()).collect(Collectors.toList());;
        System.out.println(sorted);

        System.out.println(sorted.stream().skip(1).findFirst().get());

//===========================================================

    }


    //Maximum and Minimum Element in an Array
    private void findMaximumAndMinimumElementInArray() {

        int[] arr={10,13,20,15,60,5,40,18,30,1};
        int n=arr.length-1;
        int min=arr[0];
        int max=arr[0];

        max = getMax(n, arr, max);
        min = getMin(n, arr, min);

        System.out.println("min value: "+min);
        System.out.println("max value: "+max);
    }

    private static int getMax(int n, int[] arr, int max) {
        for(int i = 1; i<= n; i++){
            if(arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    private static int getMin(int n, int[] arr, int min) {
        for(int i = 1; i<= n; i++){
            if(arr[i] < min)
                min = arr[i];
        }
        return min;
    }

}
