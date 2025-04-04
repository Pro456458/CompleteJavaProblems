package topic.corejavaconcepts.multithreading.synchronization.keyword.classlock;

/**
 * Case 2: If multiple Thread are operating on different Object, Synchronization is not needed at method level. <br><br>
 * Issue with below program<br><br>
 * in below code main method is trying to create 2 Display instance (object) and <br>
 * Ask 2 Thread to execute wish method of different Display object.<br>
 * You will get irregular output , <br>
 * You can't achieve synchronization by adding <br><br>
 * <b><u>synchronized</b></u> keyword before wish method in Display class.<br><br>
 *
 *  If you want to achieve synchronization in below case you have applied lock on class level<br>
 *  i.e. By adding <b><u>static synchronized</b></u> keyword before wish method of Display class.
 *  static keyword allow wish method to work on class level and hence synchronized keyword will get lock of class level<br>
 *  and multiple thread can perform operation once at a time.<br>
 */
public class MultiThreadAccessMultipleObject {

    public static void main(String[] args) {
        Display d1 = new Display();
        Display d2 = new Display();

        MyThread t1 = new MyThread(d1,"DHONI");
        MyThread t2 = new MyThread(d2,"YOURAJ");
        t1.start();
        t2.start();

    }
}
