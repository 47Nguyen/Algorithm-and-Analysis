
public class QuickSort {
	public static void main(String[] args) {
		int[] array = {4,71,2,61,6,46};

		quickSort(array, 0, array.length-1);

		for (int i = 0; i < array.length;i++){
			System.out.println(array[i]);
		}
	}
	static void quickSort(int[] array, int lowIndex, int highIndex){

		if (lowIndex >= highIndex){
			return;
		}

		int pivot = array[highIndex];
		int leftPointer = lowIndex;
		int rightPointer = highIndex;

		while (leftPointer < rightPointer){
			while (array[leftPointer] <= pivot && leftPointer < rightPointer){
				leftPointer++;
			}
			while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
				rightPointer--;
			}

			swap(array, leftPointer, rightPointer);
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
