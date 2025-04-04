package topic.corejavaconcepts.multithreading.concurrency.computablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;


public class AsyncExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        Runnable r = () -> {
            delay(2);
            System.out.println("Hello World");
        };

        CompletableFuture<Void> voidCompletableFuture =
                CompletableFuture.runAsync(r);


        System.out.println("Main Thread is running....");

        voidCompletableFuture.join();



    }

    public static void delay(int second){
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}



