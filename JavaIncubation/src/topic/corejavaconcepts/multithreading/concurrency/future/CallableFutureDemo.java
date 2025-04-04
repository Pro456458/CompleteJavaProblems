package topic.corejavaconcepts.multithreading.concurrency.future;

import java.util.concurrent.*;

/**
 * Future class represent the future result of asynchronous computation-<br>
 * A <b>result</b> that will eventually appear in the future after the processing the complete.<br><br>
 * In the below program at <i>line 1</i> we immediately got a future object<br>
 * that means it doesn't wait for particular operation perform in call method to be completed,<br>
 * and it will never block due to delay of 2 second occur at <i>line 3</i><br>
 * So what happen when you call <b><u><i>service.submit(job);</i></u></b> at <i>line 1</i> <br>
 * you can immediately do some other operation done at <i>line 2</i> <br>
 * And once your operation are done you can get the result by using <b><u><i>future.get()</i></u></b> method.<br>
 *<b><u><i>future.get();</i></u></b>This call is blocking i.e. you will have to wait to get the result after completing the task.<br><br>
 *
 * Using this we have 1 way  of doing some operation asynchronously.
 */
public class CallableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        MyCallable[] jobs = {new MyCallable(10),
                                new MyCallable(20),
                                new MyCallable(30),
                                new MyCallable(40),
                                new MyCallable(50)};

        ExecutorService service = Executors.newFixedThreadPool(1);

        for(MyCallable job: jobs){
            Future<Integer> future = service.submit(job);       //====================================================== line 1
            System.out.println("--XX--Maim Thread continues to run and  Doing somethings else...\nwhile services are performing its job.\nSoon it will get block by future.get()---XX");  //============ line 2
            long beforeBlock = System.currentTimeMillis();
            Integer sum = future.get();
            long afterBlock = System.currentTimeMillis();
            System.out.println(sum);
            System.out.println("Main thread was blocked for approximately " + (afterBlock - beforeBlock) + "ms.");


        }
        service.shutdown();
    }

}


class MyCallable implements Callable<Integer>{

    int num;

    public MyCallable(int num) {
        this.num = num;
    }

    @Override
    public Integer call() throws Exception {

        System.out.println(Thread.currentThread().getName()+
                " is started its job");
        int sum=0;
        for(int i=0;i<=num;i++){
            sum+=i;
        }

        deplay(2);  // ========================================================================================= line 3

        System.out.print(Thread.currentThread().getName()+
                " completed its job and find sum of first "+num+" numbers:: ");

        return sum;
    }

    private static void deplay(int timeout) throws InterruptedException {
        TimeUnit.SECONDS.sleep(timeout);
    }
}