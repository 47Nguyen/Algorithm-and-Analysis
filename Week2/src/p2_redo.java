import java.util.Arrays;

public class p2_redo {
    public static void printWithSorting(int[] A){
        Arrays.sort(A);
        System.out.println(A[0]);
        for (int i = 1; i < A.length;i++){
            if (A[i] != A[i-1]){
                System.out.println(A[i]);
            }
        }
        /**
         Arrays.sort(A); O(1)
         System.out.println(A[0]);O(1)
         for (int i = 1; i < A.length;i++){ O(N)
            if (A[i] != A[i-1]){ O(1)
                System.out.println(A[i]); O(1)
            }
         }
         Time Complexity = O(N)
         */
    }

    public static void main(String[] args) {
        int[] A = {6, 8, 10, 11, 6, 10};
        printWithSorting(A);
    }
}
