public class QuickSelect  {
	public static void main(String[] args) {
		int[] array = {9, 3, 7, 1, 6};
		System.out.println(quickSelect(array, 0,array.length-1, 1));
	}
	static int quickSelect(int[] array, int lowIndex, int highIndex, int k){
		if (lowIndex <= highIndex){
			int pivotIndex = partition(array, lowIndex, highIndex);
			if (pivotIndex == k){
				return array[pivotIndex];
			}
			else if (pivotIndex > k){
				return quickSelect(array, lowIndex, pivotIndex-1, k);
			}
			else {
				return quickSelect(array, pivotIndex+1, highIndex, k);
			}
		}
		return -1;
	}

	static int partition(int[] array, int lowIndex, int highIndex){

		int pivot = array[highIndex]; // Highest value

		int storeIndex = lowIndex;
		for (int i = lowIndex; i < highIndex;i++){
			if (array[lowIndex] <= pivot){
				storeIndex++;
				swap(array, storeIndex, i);
			}
		}
		swap(array, storeIndex, highIndex);
		return storeIndex;
	}

	static void swap(int[] array, int index1, int index2){
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] =temp;
	}
}
