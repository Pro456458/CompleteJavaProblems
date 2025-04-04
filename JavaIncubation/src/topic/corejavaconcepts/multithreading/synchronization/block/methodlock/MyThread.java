package topic.corejavaconcepts.multithreading.synchronization.block.methodlock;

class MyThread extends Thread {

    private Display d;
    private String name;

    MyThread(Display d, String name) {
        this.d = d;
        this.name = name;
    }

    @Override
    public void run() {
        d.wish(name);
    }
}
