package topic.corejavaconcepts.multithreading.concurrency.computablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class NonBlockingBehaviourExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(
                () -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    return "Result from 1st Task";
                }
        );

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(
                () ->{
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return "Result from 2nd Task";
                }
        );


        CompletableFuture<Void> voidCompletableFuture = future1.thenCombine(future2, (result1, result2) -> result1 + " and " + result2)
                .thenAccept(System.out::println);


        voidCompletableFuture.join();

        System.out.println("Main Thread continuous to run...");

    }




}
