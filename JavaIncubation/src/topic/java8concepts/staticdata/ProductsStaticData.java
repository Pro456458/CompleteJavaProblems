package topic.java8concepts.staticdata;

import topic.java8concepts.beans.Product;

import java.util.Arrays;
import java.util.List;

public class ProductsStaticData {

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
    public static List<Product> getProducts() {
        return Arrays.asList(
                new Product("Laptop", 150000.00, "Electronics"),
                new Product("Shirt", 5000.00, "Clothing"),
                new Product("Coffee Maker", 10000.00, "Home Appliances"),
                new Product("Book", 2000.00, "Books")
        );
    }
}
