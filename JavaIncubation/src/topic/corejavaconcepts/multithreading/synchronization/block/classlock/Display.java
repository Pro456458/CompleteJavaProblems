package topic.corejavaconcepts.multithreading.synchronization.block.classlock;

class Display {

    /**
     * Try to add/uncomment synchronized block, to see the difference<br>
     *
     * <b>synchronized(Display.class)</b>
     *
     */
    public void wish(String name) {
        // suppose there is a thousand line of code

        //synchronized(Display.class) {

            for (int i = 0; i < 10; i++) {
                System.out.print("Good Morning");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(":" + name);
            }

        //}

        // suppose there is a thousand line of code
    }

}
