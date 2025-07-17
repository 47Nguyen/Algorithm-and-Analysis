public class Problem1 {
    /**
     *
     Problem 1
     1.1/ Using pseudocode or Java, describe an algorithm to find the largest number in an array - without sorting the array

     Example:

     A = [7, 6, 9, 3, 2, 5] => return 9

     */
    public static int findMax(int[] A ){
        int max = A[0]; //Assume the first position is the largest number
        for (int i = 1; i < A.length; i++){
            if (A[i] > max){
                max = A[i];
            }
        }
        return max;
    }

    /**
     *
     1.2/ Using pseudocode or Java, describe an algorithm to find the second largest number in an array - without sorting the array

     Example:
     A = [7, 6, 9, 3, 2, 5] => return 7

     */
    public static int findSecondMax(int[] A){
        int firstMax = findMax(A);
        int secondMax = A[1];
        for (int i = 0; i < A.length; i++){
            if (A[i] !=firstMax){
                if (secondMax == 0 || A[i] > secondMax){
                    secondMax = A[i];
                }
            }
        }
        return secondMax;
    }

    public static void main(String[] args) {
        int[] A = {7, 6, 9, 3, 2, 5};
        System.out.println(findSecondMax(A));
    }
}