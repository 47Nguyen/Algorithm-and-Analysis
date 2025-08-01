import java.util.Arrays;
import java.util.Random;

public class GenerateIntegers {
    static int[] randomNumbers;


    static void generateValues(){
        randomNumbers = new int[1000000]; // Change 20 to your desired number of integers
        Random rand = new Random();

        // Generate random integers between 1 and 1000
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = rand.nextInt(1000) + 1;
        }

    }
    static int[] generates(int size, int max){
        int[] res = new int[size];
        for (int i = 0; i < size;i++){
            res[i] = (int) (Math.random() * max) +1;
        }
        return res;
    }
    static void generateValues10Mil(){
        randomNumbers = new int[100000]; // Change 20 to your desired number of integers
        Random rand = new Random();

        // Generate random integers between 1 and 1000
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = rand.nextInt(10^9) + 1;
        }

    }


    //Time Complexity O (n log n)
    static void sortValues(){
        //Sort array
        Arrays.sort(randomNumbers);
    }

    //Time Complexity O(n+K)
    static int[] countingSort(int[] arr, int maxValue) {
        int[] freq = new int[maxValue + 1];  // Fix: size should be maxValue + 1
        int[] res = new int[arr.length];

        // Step 1: Count frequencies
        for (int i = 0; i < arr.length; i++) {
            freq[arr[i]]++;
        }

        // Step 2: Cumulative frequency
        for (int i = 1; i <= maxValue; i++) {
            freq[i] = freq[i] + freq[i - 1];
        }

        // Step 3: Build output array (backwards for stability)
        for (int i = arr.length - 1; i >= 0; i--) {
            res[freq[arr[i]] - 1] = arr[i];
            freq[arr[i]]--;
        }

        return res;
    }
    static void printArray(int[] arr){
        for (int i =0; i < arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }

    /*
    Depending on the input size, countingSort
     */
    public static void main(String[] args) {
        int[] test = generates(10, 10);
        System.out.println("Before sorting: ");
        printArray(test);

        System.out.println();
        System.out.println("After sorting: ");
        printArray(countingSort(test, 10));

    }
}
