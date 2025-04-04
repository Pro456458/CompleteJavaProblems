package topic.corejavaconcepts.multithreading.commonproblems;

public class PrintEvenOdd {

    public static void main(String[] args) {

        Printer printer = new Printer();
        Number number = new Number(1); // Start with 1 for odd numbers
        int max = 10;

        Thread t1 = new Thread(new EvenThread(printer,number,max));
        Thread t2 = new Thread(new OddThread(printer,number,max));

        t2.start();
        t1.start();

    }

}



class EvenThread implements Runnable{

    private final Printer printer;
    private final Number number;
    private  final int maxRange;

    public EvenThread(Printer printer, Number number, int maxRange){
        this.printer = printer;
        this.number = number;
        this.maxRange = maxRange;
    }
    @Override
    public void run() {
        while (number.getNum()<maxRange){
            printer.printEven(number);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}


class OddThread implements Runnable{

    private final Printer printer;
    private final Number number;
    private  final int maxRange;

    public OddThread(Printer printer, Number number, int maxRange){
        this.printer = printer;
        this.number = number;
        this.maxRange = maxRange;
    }

    @Override
    public void run() {
        while (number.getNum()<maxRange){
            printer.printOdd(number);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}


class Printer{

    private boolean isOdd=true;

    public synchronized void printEven(Number number){
        //wait until isOdd is true
        while(isOdd){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        isOdd=true;
        System.out.println("Print Even:"+number.getNum());
        number.setNum(number.getNum()+1);
        notify();

    }

    public synchronized void printOdd(Number number){
        //wait until isOdd is false
        while (!isOdd){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Print Odd:"+number.getNum());
        number.setNum(number.getNum()+1);
        isOdd=false;
        notify();
    }
}

class Number{
    private int num;

    public Number(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}