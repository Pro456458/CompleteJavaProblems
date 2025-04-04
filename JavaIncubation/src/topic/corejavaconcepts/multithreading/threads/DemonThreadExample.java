package topic.corejavaconcepts.multithreading.threads;

public class DemonThreadExample {
    public static void main(String[] args) {
        MyDemonThread myDemonThread = new MyDemonThread();
        myDemonThread.setDaemon(true);
        myDemonThread.start();
        System.out.println("End of Maim Thread");
    }
}


class MyDemonThread extends Thread{
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("Child Thread");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}