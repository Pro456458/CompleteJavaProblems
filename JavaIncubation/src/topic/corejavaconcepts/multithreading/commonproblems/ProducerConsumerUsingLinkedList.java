package topic.corejavaconcepts.multithreading.commonproblems;

import java.util.LinkedList;

public class ProducerConsumerUsingLinkedList {

    public static void main(String[] args) {

        Buffer buffer = new Buffer();

        MyProducerThread myProducerThread = new MyProducerThread(buffer);
        MyConsumerThread myConsumerThread = new MyConsumerThread(buffer);

        Thread t1 = new Thread(myProducerThread);
        Thread t2 = new Thread(myConsumerThread);

        t1.start();
        t2.start();


        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        t1.interrupt();
//        t2.interrupt();

    }

}



class MyProducerThread implements Runnable{

    private Buffer buffer;

    public MyProducerThread(Buffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int value=0;
        while (true){
            buffer.produce(value);
            System.out.println("Produce:"+value);
            value++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


class MyConsumerThread implements Runnable{

    private Buffer buffer;

    MyConsumerThread(Buffer buffer){
        this.buffer=buffer;
    }

    @Override
    public void run() {
        int value=0;
        while (true){
            value = buffer.consume();
            System.out.println("Consume:"+value);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

class Buffer{
    private LinkedList<Integer> list = new LinkedList<>();
    private final int CAPACITY = 10;

    public void produce(int value){
        synchronized(this){
            while(list.size()==CAPACITY){
                try {
                    wait(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            list.add(value);
            notify();
        }
    }

    public int consume(){
        synchronized (this){
            while (list.isEmpty()){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            int value = list.removeFirst();
            notify();
            return value;
        }
    }

}
