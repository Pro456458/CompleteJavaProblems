package topic.corejavaconcepts.collectioninterface;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentHashMapExample {

    public static void main(String[] args) {



        ConcurrentHashMap<String,Integer> map = new ConcurrentHashMap<>();

        map.put("One",1);
        map.put("Tow",2);
        map.put("Three",3);

        Writer writer = new Writer(map);
        Reader reader1 = new Reader(map);
        Reader reader2 = new Reader(map);

        Thread writterThread = new Thread(writer);
        Thread readerThread1 = new Thread(reader1);
        Thread readerThread2 = new Thread(reader2);

        writterThread.start();
        readerThread1.start();
        readerThread2.start();

        try {
            writterThread.join();
            readerThread1.join();
            readerThread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //print the final map
        System.out.println("Final map:" + map);

    }

}


class Writer implements Runnable{

    private final ConcurrentMap<String,Integer> map;

    public Writer(ConcurrentMap<String, Integer> map) {
        this.map = map;
    }

    @Override
    public void run() {
        for(int i=4;i<6;i++) {
            map.put("Number"+i,i);
            System.out.println("Added Number "+ i);
            System.out.println("=============");
            try {
                Thread.sleep(1000); // adding some delay
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


class Reader implements Runnable{

    private ConcurrentHashMap<String,Integer> map;

    public Reader(ConcurrentHashMap<String, Integer> map) {
        this.map = map;
    }

    @Override
    public void run() {
        for(int i=0;i<6;i++){
            map.forEach((k,v)-> System.out.println("Read"+k+" = "+v));
            System.out.println("=============");
            try {
                Thread.sleep(1000); // adding some delay
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }


}
