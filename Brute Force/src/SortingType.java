import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class SortingType {

    public static void main(String[] args) {
        int[] array = {5,1,9,6,2};
        SortingType sortingType = new SortingType();
        sortingType.selectionSort(array);

    }

    void printArray(int[] arr){
        for (int i = 0; i < arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    void bubbleSort(int[] arr){
        boolean swapped = true;

        while(swapped){
            swapped = false;
            for (int i =  0; i < arr.length-1;i++){
                if (arr[i] > arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    swapped = true;
                }
            }
        }

    }
    void selectionSort(int[] arr){
        /*
        Selection Sort is a Brute Force solution to the sorting problem.
        1. Scan all n elements of the array to find the smallest
        element, and swap it with the first element.
        2. Starting with the second element, scan the remaining n −
        1 elements to find the smallest element and swap it with
        the element in the second position.
        3. Generally, on pass i (0 ≤ i ≤ n − 2), find the smallest
        element in A[i ... n − 1] and swap it with A[i].
         */
        for (int i = 0; i < arr.length-1;i++){
            int minIndex = i;
            for (int j = i+1 ; j < arr.length;j++){
                if (arr[j] < arr[minIndex]){
                    minIndex = j; //New index integer with the lower min value

                }
            }
            //Swap
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] =temp;
            System.out.print("Iterations: " + (i+1) + " ");
            printArray(arr);
        }

    }
}
