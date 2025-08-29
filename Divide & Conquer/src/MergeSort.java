public class MergeSort {
	public static void main(String[] args) {
		int[] array = {4,6,71,2,61,46};

		mergeSort(array);
		for (int i =0; i < array.length;i++){
			System.out.println(array[i]);
		}
	}

	static void mergeSort(int[] array){
		int n = array.length;
		if (n < 2){
			return;
		}
		int mid = n/2;

		int[] left = new int[mid];
		int[] right = new int[n-mid];

		//Populate
		for (int i = 0; i < mid;i++){
			left[i] = array[i];
		}
		for (int j =mid; j < n;j++){
			right[j-mid] = array[j];
		}


		mergeSort(left);
		mergeSort(right);

		merge(array, left, right);
	}

	static void merge(int[] array, int[] leftHalf, int[] rightHalf){
		int leftSize = leftHalf.length;
		int rightSize = rightHalf.length;

		int i = 0, j = 0, k =0;

		while (i < leftSize && j < rightSize){
			if (leftHalf[i] <= rightHalf[j]){
				array[k] = leftHalf[i];
				i++;
			}
			else {
				array[k] = rightHalf[j];
				j++;
			}
			k++;
		}

		while (i < leftSize){
			array[k] = leftHalf[i];
			i++;
			k++;
		}
		while (j < rightSize){
			array[k] = rightHalf[j];
			j++;
			k++;
		}
	}

}
