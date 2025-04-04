package topic.corejavaconcepts.multithreading.concurrency.computablefuture;

import java.util.concurrent.*;

/**
 * Question: How would you convert a Synchronous API to an Asynchronous API using CompletableFutureUsedAsFuture ?<br><br>
 * Answer : 1) Create A CompletableFuture that will contain the result of computation.<br>
 * 2) Execute the computation in a separate thread // you can use ExecutorService or Thread using Runnable or Callable<br>
 * 3) Return the CompletableFuture Immediately: Don't wait for the computation to finish; the result will be available in the future.<br><br>
 *
 * we can create an instance of CompletableFuture class with a no-arg constructor to represent some future result.<br>
 * calculateAsync method return Future which we can use to get the result<br>
 * in main method when we are ready to block for the result;<br>
 */
public class CompletableFutureUsedAsFuture {


    public Future<String> calculateAsync(){

        // create completable future that will contain result of computation
        CompletableFuture<String> futureResult = new CompletableFuture<>();


        Executors.newCachedThreadPool().submit(
                () -> {
                    delay(2);                   // add a delay of 2 sec
                    String msg = "World";               // execute a task in a separate thread
                    futureResult.complete(msg);         //The complete() method is used to complete a Future object
                                                        //which is generally used to indicate that the associated task is finished
                }
        );

        //return the result without waiting for the computation of the result being completed
        return futureResult;
    }

    private void delay(int second){
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {

        CompletableFutureUsedAsFuture completableFutureUsedAsFuture = new CompletableFutureUsedAsFuture();

        try {

            // the get() method, on the other hand, is used to retrieve the result of a Future object
            String result = completableFutureUsedAsFuture.calculateAsync().get();
            System.out.println("Hello "+result);
            System.out.println("Main Thread Execute...");


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }

}
