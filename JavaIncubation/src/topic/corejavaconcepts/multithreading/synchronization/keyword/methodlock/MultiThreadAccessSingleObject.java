package topic.corejavaconcepts.multithreading.synchronization.keyword.methodlock;

/**
 * Case 1 : If multiple Thread are operating on a single Object, Synchronization is needed. <br><br>
 * Issue with below program<br><br>
 * in below code main method is trying to create one Display instance (object) and <br>
 * Ask Multiple Thread to execute wish method of Display object.<br>
 * Calling of wish method is not in sync,so you will get irregular output , <br>
 * If you want to achieve synchronization in below code, add <br><br>
 * <b>synchronized<b/> keyword before wish method in Display class.
 */
public class MultiThreadAccessSingleObject {

    public static void main(String[] args) {
        Display d = new Display();

        MyThread t1 = new MyThread(d,"DHONI");
        MyThread t2 = new MyThread(d,"YOURAJ");
        t1.start();
        t2.start();

    }

}

