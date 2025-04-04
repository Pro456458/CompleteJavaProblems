package topic.corejavaconcepts.multithreading.synchronization.block.classlock;

/**
 * Case 2: If multiple Thread are operating on different Object, Synchronization is not needed at method level. <br><br>
 * Issue with below program<br><br>
 * in below code main method is trying to create 2 Display instance (object) and <br>
 * Ask 2 Thread to execute wish method of Display object,  <b><u>which contain a thousand of line</u></b><br>
 * So, You will get irregular output , <br>
 * You can achieve synchronization by adding <b><u>static synchronized</b></u> keyword before wish method in Display class.<br><br>
 * <b><u>but that will reduce the performance</b></u><br>
 * So, If you want to achieve synchronization in below case then add specific code under <br><br>
 * <b>synchronized<b/> block and pass Display.class as argument inside wish method of Display class.<br><br>
 * <b><u>Note:<b/><u/> to see the correct result check Display class under same package
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