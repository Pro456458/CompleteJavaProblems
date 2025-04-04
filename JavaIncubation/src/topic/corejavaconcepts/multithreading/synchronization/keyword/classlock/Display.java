package topic.corejavaconcepts.multithreading.synchronization.keyword.classlock;

class Display {

    /**
     * If you want to achieve synchronization when multiple threads are operating on multiple object of Display class then<br>
     * you need to add <b>static synchronized</b> keyword before wish method that will allow you get lock on class level <br>
     *
     * <b>public synchronized void wish(String name)</b>
     *
     */
    public static synchronized void wish(String name) {

        for (int i = 0; i < 10; i++) {
            System.out.print("Good Morning");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(":" + name);
        }

    }

}
