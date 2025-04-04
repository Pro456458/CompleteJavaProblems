package topic.java8concepts.commonproblems;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ListCreationExample {

    public static void main(String[] args) {

        listCreationFromArray();
        listCreationFromStreamOf();
    }

    /**
     * Stream.of(t).toList() <b>
     * Creates an immutable list. Any attempt to modify the list will throw an UnsupportedOperationException <b>
     * Java 8 stream operation can be performed on it. <b>
     */
    private static void listCreationFromStreamOf() {
        String[] t = {"1","2","3","4","5"};
        List<String> list = Stream.of(t).toList();
        System.out.println(list);
        list.set(0,"10");   //throw an UnsupportedOperationException
        list.add("16");       //throw an UnsupportedOperationException

    }

    /**
     * Nature of List create by Arrays.asList()<br>
     * Fixed Size: The list created by Arrays.asList() is convert from an array to a fixed-size list.<br>
     * This List is just a wrapper that makes the array available as a list. No data is copied or created.<br>
     * This means you cannot add or remove elements from the list. <br>
     * Attempting to do so will result in an <b>UnsupportedOperationException</b><br>
     * String[] stringArray = {"a", "b", "c"};<br>
     * List<String> list = Arrays.asList(stringArray);<br>
     * list.set(0, "z"); // Works fine<br>
     * System.out.println(arraysAsList);            //[z, b, c]<br>
     * System.out.println(Arrays.toString(array));  //[z, b, c]<br>
     * list.add("d"); // Throws UnsupportedOperationException
     */
    private static void listCreationFromArray() {
        String[] array = {"2", "5", "4","3","7"};
        List<String> arraysAsList = Arrays.asList(array);
        System.out.println(arraysAsList);               //  o/p -> [2, 5, 4, 3, 7]

        arraysAsList.set(4,"10");        // allow operation as it doesn't modify the original list
        System.out.println(arraysAsList);               //  o/p -> [2, 5, 4, 3, 10]
        System.out.println(Arrays.toString(array));     //  o/p -> [2, 5, 4, 3, 10]

        arraysAsList.add("15"); // Throws UnsupportedOperationException
    }
}
