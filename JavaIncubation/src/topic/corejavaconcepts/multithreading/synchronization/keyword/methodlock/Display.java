package topic.corejavaconcepts.multithreading.synchronization.keyword.methodlock;

class Display {

    /**
     * If you want to achieve synchronization while calling wish method from multiple thread<br>
     * you need to add <b>synchronized</b> keyword before wish method that will allow you get lock on object level <br>
     *
     * <b>public synchronized void wish(String name)</b>
     *
     */
    public synchronized void wish(String name) {

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
