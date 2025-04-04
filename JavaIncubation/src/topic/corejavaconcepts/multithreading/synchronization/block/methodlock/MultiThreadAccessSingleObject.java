package topic.corejavaconcepts.multithreading.synchronization.block.methodlock;

/**
 * Case 1 : If a thousand line of code written in a class and multiple Thread are operating on a Single Object,<br>
 * then Synchronization is needed on block level not on method or class level. <br><br>
 * Issue with below program<br><br>
 * in below code main method is trying to create one Display instance (object) and <br>
 * Ask Multiple Thread to execute wish method of Display object,  <b><u>which contain a thousand of line</u></b><br>
 * then you will get irregular output , <br>
 * You can achieve synchronization by adding <b><u>synchronized</b></u> keyword before wish method in Display class.<br><br>
 * <b><u>but that will reduce the performance</b></u><br>
 * If you want to achieve synchronization in below code, add specific code under <br><br>
 * <b>synchronized<b/> block inside wish method and pass current object i.e. this of Display class.<br><br>
 * <b><u>Note:<b/><u/> to see the correct result check Display class under same package
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