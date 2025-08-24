import java.util.Random;

public class Quicksort {
	public static void main(String[] args) {
		Random random = new Random();
		int[] array = new int[1000];

		for(int i = 0; i < array.length;i++){
			array[i] = random.nextInt(10000);
		}
		// Before
//		printArray(array);

		//After
		quickSort(array, 0, array.length-1);
		printArray(array);
	}


	static void printArray(int[] array){
		for (int j : array) {
			System.out.print(j + " ");
		}

	}

	static void quickSort(int[] array, int lowIndex, int highIndex){
		if (lowIndex >= highIndex){
			return;
		}
		int pivot = array[highIndex];
		int leftPointer = lowIndex;
		int rightPointer = highIndex;

		while(leftPointer < rightPointer){
			while(array[leftPointer] <= pivot && leftPointer < rightPointer){
				leftPointer++;
			}
			while (array[rightPointer] >= pivot && leftPointer < rightPointer){
				rightPointer--;
			}
			swap(array, leftPointer, rightPointer); //When 1st while loop found the condition and second while loop founds it value. They swap
		}

		swap(array, leftPointer, highIndex);
		quickSort(array, lowIndex, leftPointer-1);
		quickSort(array, leftPointer+1, highIndex);
	}

	static void swap(int[] array, int index1, int index2){
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
}
