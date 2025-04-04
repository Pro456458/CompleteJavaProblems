package topic.client.expedia.subarraypattern;

public class CombinationOfConsecutiveNumbers {

    public static void main(String[] args) {

        //int[] numbers = {2, 3, -8, 7, -1, 2, 3};  // [7 -1 2 3 ] MAX_SUM=11
        int[] numbers = {1,2,3,4,5,6,7,8,9};  // [1 2 3 4 5 6 7 8 9 ] MAX_SUM=45
        System.out.println(countConsecutiveCombinationsBruteForceMethod(numbers));  // Output: 4
    }

    private static int countConsecutiveCombinationsBruteForceMethod(int[] numbers) {

        int n =numbers.length;
        int currentSum =0;
        int maxSum=0;

        for(int i=0;i<=n-1;i++){
            for(int j=i;j<=n-1;j++){
                currentSum=0;
                System.out.print("=>[");
                for(int k=i; k<=j; k++){
                    System.out.print(numbers[k]+" ");
                    currentSum+=numbers[k];
                }
                System.out.print("]");
                System.out.print(" SUM="+ currentSum);
                maxSum= Math.max(maxSum,currentSum);
                System.out.println(", MAX="+ maxSum);
            }
        }
        return maxSum;
    }
}
