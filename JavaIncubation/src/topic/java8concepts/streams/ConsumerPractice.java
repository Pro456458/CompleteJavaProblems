package topic.java8concepts.streams;

import topic.java8concepts.staticdata.ProductsStaticData;
import topic.java8concepts.beans.Product;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerPractice {

    public static void main(String[] args) {

        List<Product> products = ProductsStaticData.getProducts();
        System.out.println("Original Product");
        products.forEach(System.out::println);
        System.out.println("XX===========XX============XX");


        // Consumer to increase the price based on criteria
        Consumer<Product> increasePrice = product -> {

            if ("Electronics".equals(product.getCategory()) && product.getPrice() > 1000) {
                product.setPrice(product.getPrice()*1.10); // Increase by 10%
            } else if ("Clothing".equals(product.getCategory()) && product.getPrice() < 100) {
                product.setPrice(product.getPrice()*1.05); // Increase by 5%
            }

        };

        // Consumer to print the product name
        Consumer<Product> printName = product -> System.out.println(product.getName());

        // Process and print products
        products.stream()
                .peek(increasePrice)
                .forEach(printName);

        // Calculate the total value of modified products
        double totalValue = products.stream()
                .mapToDouble(product -> product.getPrice())
                .sum();

        // Print the total value
        System.out.println("Total value of modified products: Rs " + totalValue);


    }
}
