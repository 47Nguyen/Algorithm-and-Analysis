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

    //Time Complexity O (n log n)
    static void sortValues(){
        //Sort array
        Arrays.sort(randomNumbers);
    }

    //Time Complexity O(n)
    static void countingSort(){
        int maxValue = 0;

        //Find max value
        for (int i = 0; i < randomNumbers.length; i++)
            if (randomNumbers[i] > maxValue){
                maxValue = randomNumbers[i];
            }

        int[] count = new int[maxValue + 1];

        //Count the occurences of each unique values
        for (int num : randomNumbers){
            count[num]++;
        }

        int index = 0;
        for (int i =0 ; i<= maxValue;i++){
            while (count[i] --> 0){
                randomNumbers[index++] = i;
            }
        }

    }

    public static void main(String[] args) {
        generateValues();
        sortValues();
        countingSort();
    }
}
