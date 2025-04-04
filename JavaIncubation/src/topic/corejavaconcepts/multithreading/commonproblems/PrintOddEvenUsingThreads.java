package topic.corejavaconcepts.multithreading.commonproblems;

public class PrintOddEvenUsingThreads {

    //Number 1,2,3,4,5,6,7,8,9,10
    // create 2 thread
    // T1 print odd number
    // T2 print even number
    // 1 Class Printer whose object is used by T1 and T2

    public static void main(String[] args) {

        Numbers numbers = new Numbers(1,true);

        PrintEvenOddNumber printEvenOddNumber = new PrintEvenOddNumber();

        MyThreadForOdd  t1= new MyThreadForOdd(printEvenOddNumber,numbers,10);
        MyThreadForEven t2= new MyThreadForEven(printEvenOddNumber,numbers,10);

        t1.start();
        t2.start();

    }

}

class MyThreadForEven extends Thread{
    private PrintEvenOddNumber printEvenOddNumber;
    private Numbers numbers;
    private int max;

    public MyThreadForEven(PrintEvenOddNumber printEvenOddNumber, Numbers numbers, int max){
        this.printEvenOddNumber = printEvenOddNumber;
        this.numbers=numbers;
        this.max = max;
    }

    @Override
    public void run() {
        while (numbers.getValue()<=max) {
            System.out.println("MyThreadForEven print :");
            printEvenOddNumber.printEvenNumber(numbers);
        }
    }
}

class MyThreadForOdd extends Thread{
    PrintEvenOddNumber printEvenOddNumber;
    private Numbers numbers;
    private int max;

    public MyThreadForOdd(PrintEvenOddNumber printEvenOddNumber, Numbers numbers, int max){
        this.printEvenOddNumber = printEvenOddNumber;
        this.numbers=numbers;
        this.max=max;
    }

    @Override
    public void run() {

        while(numbers.getValue()<=max) {
            System.out.println("MyThreadForOdd print :");
            printEvenOddNumber.printOddNumber(numbers);
        }
    }
}

class PrintEvenOddNumber {


    public synchronized void printEvenNumber(Numbers numbers){

        while (numbers.isOdd()){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(numbers.getValue());
        numbers.setOdd(true);
        numbers.setValue(numbers.getValue()+1);
        notify();
    }
    public synchronized void printOddNumber(Numbers numbers){

        while (!numbers.isOdd()){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(numbers.getValue());
        numbers.setOdd(false);
        numbers.setValue(numbers.getValue()+1);
        notify();
    }

}


class Numbers{
    private int value;

    private boolean odd=true;

    public Numbers(int value, boolean odd) {
        this.value = value;
        this.odd = odd;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isOdd() {
        return odd;
    }

    public void setOdd(boolean odd) {
        this.odd = odd;
    }
}


