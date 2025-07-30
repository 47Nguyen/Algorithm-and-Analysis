public class problem2 {

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
        /**
         *         int N = 5;  O(1)
         *         int sumVal = 15; O(1)
         *         int sum = 0; O(1)
         *         int missingVal = 0; O(1)
         *
         *         for (int i = 0; i < A.length; i++){ O(N)
         *             sum += A[i]; O(N)
         *             if (sum == sumVal && A.length < N){ O(N)
         *                 missingVal = 0; O(N)
         *             }
         *             else {
         *                 missingVal = sumVal-sum; O(N)
         *             }
         *         }
         *         return missingVal; O(1)
         *
         *         Big-O notation = O(N)
         */
    }

    public static int findMissingNumber(int[] A){
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
        System.out.println(findMissingNumber(A));
        System.out.println(findMissingNumber(B));
        System.out.println(findMissingNumber(C));

    }
}
