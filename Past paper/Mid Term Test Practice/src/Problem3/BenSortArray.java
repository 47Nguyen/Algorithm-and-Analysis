package Problem3;

import java.util.Arrays;

public class BenSortArray {
    private int position(int[] A, int X){
        Arrays.sort(A);
        int N = A.length;
        for (int i = 0; i < N-1; i++){
            if (X < A[i])
                return 0;
        }
        return N;
    }

    public static void main(String[] args) {
        int[] A = {2, 4, 7, 9, 11, 20};
        int X = 5;
    }
}
