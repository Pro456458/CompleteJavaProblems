import java.util.ArrayList;
import java.util.List;

public class TestDemo {

    public static void main(String[] args) {

        // write a program for below task
        // in this task you are given two strings of digits
        // that represent (possibly very large) integers.
        // Your goal is to make those numbers as close to one another
        // as possible. In other words, you want to minimize the absolute value of their difference.
        // You can swap some of the corresponding digits
        // (e.g. the first digit of the first number with the first digit of the second number)
        // Swapping the digits is an extremely tiring task, so you want to make as few swaps as possible.

        // Write a function
        // public int solution(String S, String T);

        TestDemo testDemo = new TestDemo();
        int solution = testDemo.solution("29162", "10524");

        System.out.println(solution);

    }


    public int solution(String S, String T) {
        int result = 0;
        char[] num1Array = S.toCharArray();
        char[] num2Array = T.toCharArray();


        //List to store positions when swap occurred(to count swap)
        List<Integer> swapPositions = new ArrayList<>();


        //find all digit where difference is not same
        for(int i=0; i<S.length(); i++) {
            if(num1Array[i] != num2Array[i]) {
                swapPositions.add(i);
            }
        }


        //try to swap digits to minimize the difference

        for(int i=0; i<swapPositions.size(); i++) {
            int index = swapPositions.get(i);

            if(shouldSwap(num1Array, num2Array, index)) {
                char temp = num1Array[index];
                num1Array[index] = num2Array[index];
                num2Array[index] = temp;
                result++;
            }

        }
        return result;
    }

    private boolean shouldSwap(char[] num1Array, char[] num2Array, int index) {

        char num1Char = num1Array[index];
        char num2Char = num2Array[index];

        return num1Char > num2Char;
    }

}



