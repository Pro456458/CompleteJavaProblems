package topic.corejavaconcepts.multithreading.concurrency.threadpoolorexecutorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo1 {

    public static void main(String[] args) {

        PrintJob[] printJobs = {new PrintJob("Pro"),
                                new PrintJob("Petro"),
                                new PrintJob("Musk"),
                                new PrintJob("Alen")};


        ExecutorService executorService = Executors.newFixedThreadPool(2);
        //ExecutorService executorService = Executors.newSingleThreadExecutor();
        //ExecutorService executorService = Executors.newCachedThreadPool();
        //ExecutorService executorService = Executors.newScheduledThreadPool(4);

        for(PrintJob printJob:printJobs){
            executorService.submit(printJob);
        }
        executorService.shutdown();

    }

}


class PrintJob implements Runnable{

    private String name;

    public PrintJob(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name+"..job started by Thread "+
                Thread.currentThread().getName());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(name+"..job completed by Thread "+
                Thread.currentThread().getName());

    }
}
