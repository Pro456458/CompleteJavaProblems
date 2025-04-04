package topic.corejavaconcepts.multithreading.synchronization.keyword.classlock;

class MyThread extends Thread {

    private Display d;
    private String name;

    MyThread(Display d, String name) {
        this.d = d;
        this.name = name;
    }

    @Override
    public void run() {
        Display.wish(name);
    }
}
