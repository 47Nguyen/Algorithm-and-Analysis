import javax.xml.transform.Source;

public class Problem2 {

    /**
     * Problem 2
     * An array A of length N contains unique integers between zero and N. Because there are (N + 1) different values but only N elements,
     * there is one value missing. Implement an algorithm using pseudocode or Java to find the missing value.
     * Examples (N = 5 in the below examples):
     * 1/ A = [0, 3, 2, 4, 1] => return 5
     * 2/ A = [1, 5, 2, 4, 3] => return 0
     * 3/ A = [4, 0, 1, 5, 2] => return 3
     */

    public static int findMissingVal(int[] A){
        int N = 5; // Length of an array
        int sumVal = 15;
        int sum = 0;
        int missingVal = 0;


        for (int i = 0; i < A.length; i++){
            sum += A[i];
            if (sum == sumVal && A.length < N){
                missingVal = 0;
            }
            else {
                missingVal = sumVal-sum;
            }
        }
        return missingVal;
    }

    public static int findMisisngNumber(int[] A){
        int N = A.length; //Array length
        int expectedSum = N * (N+1)/2; //Formula we can use to calculate the sum from "0 to N"

        int actualSum = 0;
        for (int num : A){
            actualSum += num;
        }

        return expectedSum - actualSum;
    }
    public static void main(String[] args) {
        int[] A = {0, 3, 2, 4, 1};
        int[] B = {1, 5, 2, 4, 3};
        int[] C = {4, 0, 1, 5, 2};
        System.out.println(findMisisngNumber(A));
        System.out.println(findMisisngNumber(B));
        System.out.println(findMisisngNumber(C));

    }
}
