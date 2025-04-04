package topic.corejavaconcepts.multithreading.concurrency.lock;

import java.util.concurrent.locks.ReentrantLock;

public class LockExampleUsingReentrantLock1 {

    public static void main(String[] args) {

        Display d = new Display();

        Runnable r1 = () -> d.wish("Dhoni");
        Runnable r2 = () -> d.wish("Yuvraj");

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

    }
}

class Display{

    ReentrantLock l = new ReentrantLock();

    public void wish(String name){

        l.lock();

        for(int i=0;i<10;i++){
            System.out.print("Good Morning:");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name);
        }

        l.unlock();
    }

}