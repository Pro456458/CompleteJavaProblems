package topic.corejavaconcepts.multithreading.concurrency.computablefuture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Question:What is the supplyAsync Method in CompletableFuture ? <br><br>
 * Answer: supplyAsync method take Supplier as an argument and return a completable future
 * that will be asynchronously completed with the value obtain by invoking the Supplier.
 */
public class SupplyAsyncExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<Shop> shops = Arrays.asList(new Shop("Grocesy",100),
                new Shop("Electronic",500),
                new Shop("Sweets",400),
                new Shop("Sport",800));


        List<String> prices = new ArrayList<>();


        //below code return the list of CompletableFuture<String>
        List<CompletableFuture<String>> priceFutures  =shops.stream().
                map(shop -> CompletableFuture.
                        supplyAsync( () -> String.format("%s price is %d",shop.getName(), shop.getPrize())
                        )
                ).toList();


        //combining all the futurist result into a List<String>
        for(CompletableFuture<String> priceFuture : priceFutures){
            String price = priceFuture.join();
            prices.add(price);
        }
        prices.forEach(System.out::println);


        //alternative of above code using join instead of get
        //priceFutures.stream().map(CompletableFuture::join).forEach(System.out::println);



    }


}



class Shop {

    private String name;
    private long prize;

    public Shop(String name, long prize) {
        this.name = name;
        this.prize = prize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrize() {
        return prize;
    }

    public void setPrize(long prize) {
        this.prize = prize;
    }
}