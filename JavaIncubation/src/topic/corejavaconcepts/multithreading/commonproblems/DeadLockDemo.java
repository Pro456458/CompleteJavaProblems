package topic.corejavaconcepts.multithreading.commonproblems;

public class DeadLockDemo {

    public static void main(String[] args) {

        DeadLockThread deadLockThread = new DeadLockThread();
        deadLockThread.m1();
    }
}

class DeadLockThread extends Thread{

    A a = new A();
    B b = new B();

    public void m1(){
        this.start();
        a.d1(b);    // run by main threads
    }

    @Override
    public void run() {
        b.d2(a);  // run by child thread DeadLockThread
    }
}


class A{
    public synchronized void d1(B b){
        System.out.println("Thread 1 start execution of d1() method");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread 1 trying to call b.last()");
        b.last();
    }
    public synchronized void last(){
        System.out.println("inside A last method");
    }
}

class B{
    public synchronized void d2(A a){
        System.out.println("Thread 2 start execution of d2() method");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread 2 trying to call a.last()");
        a.last();
    }
    public synchronized void last(){
        System.out.println("inside B last method");
    }

}