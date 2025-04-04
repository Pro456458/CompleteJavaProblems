package topic.corejavaconcepts.multithreading.threadgroup;

import java.util.Arrays;

public class ThreadGroupMethodExample {

    public static void main(String[] args) {

        setMaxPriorityInThreadGroup();
        System.out.println("================================");
        printAllActiveThreadUnderAThreadGroup();

    }

    private static void printAllActiveThreadUnderAThreadGroup() {
        Thread[] tArray = new Thread[10];

        Thread.currentThread().
                getThreadGroup().
                getParent().enumerate(tArray);

        System.out.println(Arrays.toString(tArray));
    }

    /**
     *  Threads in a ThreadGroup, that have already higher priority,
     *  won't be affected but for newly added thread this MaxPriority
     *  is applicable.
     */
    private static void setMaxPriorityInThreadGroup() {

        ThreadGroup g = new ThreadGroup("tg");

        Thread t1 = new Thread(g,"thread1");
        Thread t2 = new Thread(g,"thread2");

        g.setMaxPriority(3);
        Thread t3 = new Thread(g,"thread2");

        System.out.println(t1.getPriority()); // 3
        System.out.println(t2.getPriority()); // 3
        System.out.println(t3.getPriority()); // 5

    }
}
