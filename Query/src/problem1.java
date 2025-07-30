public class problem1 {
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
        /**
         *         int max = A[0];  O (1)
         *         for (int i = 1; i < A.length; i++){ O(N)
         *             if (A[i] > max){ O (1)
         *                 max = A[i]; O (1)
         *             }
         *         }
         *         return max; O(1)
         *
         *         => O(1) + O(1) + O(1) + O(1) + O(N)
         *         => Big-o notation = O(N)
         */
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
        /**
         *  int firstMax = findMax(A); O(1)
         *  int secondMax = A[1]; O(1)
         *  for (int i = 0; i < A.length; i++){ O(N)
         *      if (A[i] !=firstMax){ O(1)
         *          if (secondMax == 0 || A[i] > secondMax){ O(1)
         *              secondMax = A[i]; O(1)
         *          }
         *      }
         *  }
         *  return secondMax; (1)
         */
    }

    public static void main(String[] args) {
        int[] A = {7, 6, 9, 3, 2, 5};
        System.out.println(findSecondMax(A));
    }
}