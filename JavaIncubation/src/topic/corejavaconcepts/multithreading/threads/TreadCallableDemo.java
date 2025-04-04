package topic.corejavaconcepts.multithreading.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TreadCallableDemo {

    public synchronized static void main(String[] args) {

        Callable<Object> callable = new MyCallableThread();

        FutureTask<Object> futureTask = new FutureTask<>(callable);

        Thread thread = new Thread(futureTask);

        System.out.println("Thread in Main 1");
        thread.start();
        System.out.println("Thread in Main 2");

        try {
            System.out.println("Get Future task response :"+futureTask.get().getClass().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }


    }


}


class MyCallableThread implements Callable<Object>{

    @Override
    public Object call() throws Exception {
        System.out.println("Thread in MyCallableThread");
        return new Object();
    }
}


