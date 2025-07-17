import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.util.Arrays;
import java.util.HashSet;

public class Problem2 {
    public static void printUniqueWithSorting(int[] arr) {
        /**
         * Faster method
         * Less step required and only use 1 loop.
         */
        Arrays.sort(arr); // Sort the array of transcending

        System.out.println(arr[0]);
        for (int i = 1 ;i < arr.length; i++){
            /**
             * Start at one because, the index at 0 doesn't compare to any value before it
             * hence why when we do arr[i] compare with arr[i-1] the value will be out of bound.
             *
             */
            if (arr[i] != arr[i-1]){
                System.out.println(arr[i]);
            }
        }
    }

    public static void printUniqueWithoutSorting(int[] arr) {
        /**
         * A lot slower
         */
        int n = arr.length;
        int[] unique = new int[n];
        int size = 0;

        for (int i = 0; i < n; i++) {
            /**
             * Slower because you are using a nested loop to check for every pair
             * to see if the numbers are repeated more than once.
             */
            boolean found = false;

            // Check if arr[i] is already in unique[]
            for (int j = 0; j < i-1; j++) {
                if (arr[i] == unique[j]) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                unique[size++] = arr[i];
                System.out.print(arr[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 8, 10, 11, 6, 10};
//        printUniqueWithoutSorting(arr);
        printUniqueWithoutSorting(arr);

    }
}
