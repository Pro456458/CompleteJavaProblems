package topic.corejavaconcepts.multithreading.concurrency.lock;

import java.util.concurrent.locks.ReentrantLock;

public class LockExampleUsingReentrantLock2 {
    public static void main(String[] args) {

        Runnable r1 = new MyThread();
        Runnable r2 = new MyThread();

        Thread t1 = new Thread(r1,"1st Thread");
        Thread t2 = new Thread(r2,"2nd Thread");

        t1.start();
        t2.start();

    }
}

class MyThread implements Runnable{

    static ReentrantLock reentrantLock = new ReentrantLock();

    @Override
    public void run() {

        if(reentrantLock.tryLock()){
            System.out.println(Thread.currentThread().getName()+
                    "...get the lock and performing safe operations");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            reentrantLock.unlock();
        }else {
            System.out.println(Thread.currentThread().getName()+
                    "...unable to get the lock, hence performing alternative operations");
        }
    }
}
