package topic.workshop.feb26;

public class PrintOddEvenNoUsingThreads {

    public static void main(String[] args) {

        Numbers numbers = new Numbers(1);
        PrintNumbers printNumbers = new PrintNumbers();
        int maxRange =10;
        
        ThreadForOddNum t1 = new ThreadForOddNum(printNumbers,numbers,maxRange);
        ThreadForEvenNum t2 = new ThreadForEvenNum(printNumbers,numbers,maxRange);
        
        t1.start();
        t2.start();
        

    }
}


class ThreadForOddNum extends Thread{

    private Numbers num;
    private PrintNumbers printNumbers;
    private int max;

    public ThreadForOddNum(PrintNumbers printNumbers,Numbers num, int max) {
        this.printNumbers = printNumbers;
        this.num = num;
        this.max = max;
    }

    @Override
    public void run() {
        while (num.getValue()<=max){
            printNumbers.printOddNumbers(num);
        }
    }
}

class ThreadForEvenNum extends Thread{

    private Numbers num;
    private PrintNumbers printNumbers;
    private int max;

    public ThreadForEvenNum(PrintNumbers printNumbers, Numbers num, Integer max){
        this.printNumbers = printNumbers;
        this.num = num;
        this.max = max;
    }


    @Override
    public void run(){
        while(num.getValue()<max){
            printNumbers.printEvenNumbers(num);
        }
    }
}


class PrintNumbers{


    public synchronized void printOddNumbers(Numbers num){

        while((num.getValue()%2)!=0){
        //while (!num.isOdd()){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(num.getValue());
        //num.setOdd(false);
        num.setValue(num.getValue()+1);
        notify();

    }

    public synchronized void printEvenNumbers(Numbers num){

        while((num.getValue()%2)==0){
        //while (num.isOdd()){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(num.getValue());
        //num.setOdd(true);
        num.setValue(num.getValue()+1);
        notify();

    }

}



class Numbers{

    private int value;
    private boolean odd = true;

    /*public Numbers(int value, boolean odd) {
        this.value = value;
        this.odd = odd;
    }*/

    public Numbers(int value) {
        this.value = value;
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
