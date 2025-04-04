package topic.corejavaconcepts.multithreading.concurrency.computablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * In below example you will see how thenApply and thenAccept method apply
 * to the result obtained by the completable future
 */
public class CallbackExample {

    public static void main(String[] args) {


        CompletableFuture<String> completableFuture =
                CompletableFuture.supplyAsync(
                        () -> {
                            delay(2);
                            System.out.println("1st task is executing by "+Thread.currentThread().getName());
                            return "Return by 1st completable future";
                        }
                );


        completableFuture
                .thenApply(String::toUpperCase)    // callback method thenApply
                .thenAccept(System.out::println);  // callback method thenAccept

        completableFuture.join();

    }

    private static void delay(int second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
