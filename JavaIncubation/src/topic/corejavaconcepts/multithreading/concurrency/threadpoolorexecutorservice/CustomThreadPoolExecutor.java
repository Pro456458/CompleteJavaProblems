package topic.corejavaconcepts.multithreading.concurrency.threadpoolorexecutorservice;

import java.util.concurrent.*;

public class CustomThreadPoolExecutor {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // Core and maximum pool size
        int corePoolSize =2;
        int maximumPoolSize=Integer.MAX_VALUE;
        // Time that excess idle threads will wait for new tasks before terminating
        long keepAliveTime=10;
        TimeUnit unit= TimeUnit.SECONDS;

        // Task queue to hold runnable tasks
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(10);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                corePoolSize,maximumPoolSize,keepAliveTime,unit,workQueue,
                new ThreadPoolExecutor.CallerRunsPolicy()); // Rejection Policy

        MyCallableThread1[] jobs = {new MyCallableThread1(10),
                new MyCallableThread1(20),
                new MyCallableThread1(30),
                new MyCallableThread1(40),
                new MyCallableThread1(50)};



        for(MyCallableThread1 job:jobs){
            Future<Integer> future=threadPoolExecutor.submit(job);

            System.out.println(future.get());

        }

        threadPoolExecutor.shutdown();


    }
}

class MyCallableThread1 implements Callable<Integer>{

    private int num;

    public MyCallableThread1(int num) {
        this.num = num;
    }

    @Override
    public Integer call() throws Exception {

        System.out.print(Thread.currentThread().getName()+
                " is responsible to find sum of first "+num+" numbers:");

        int sum=0;
        for(int i=1;i<=num;i++) {
            sum += i;
        }
        Thread.sleep(2000);
        return sum;
    }

}