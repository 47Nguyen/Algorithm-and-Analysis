import java.util.Random;

public class CountInversion {
	public static void main(String[] args) {
		Random rand = new Random();
		int[] array = new int[50];
		for (int i = 0; i < array.length;i++){
			array[i] = rand.nextInt(2000);
		}

//		countInversion(array);
	}
	static int countInversion(int[] arr){
		int[] array = new int[arr.length];


		// Create a temporary array for merging
		int[] temp = new int[arr.length];
		return mergeSortAndCount(arr, temp, 0, arr.length - 1);
	}

	//Merge sort + count inversions
	static int mergeSortAndCount(int[] array, int[] temp, int left, int right){
		int count = 0;
		if (left < right){
			int mid = left + (right - left) /2;
			// Count inversions in left half
			count += mergeSortAndCount(array, temp, left, mid);

			// Count inversions in right half
			count += mergeSortAndCount(array, temp, mid + 1, right);

			// Count inversions between left and right halves during merge
			count += mergeAndCount(array, temp, left, mid, right);
		}
		return count;
	}

	static int mergeAndCount(int[] array, int[] temp, int left, int right, int mid){
		// Copy data to temp arrays
		for (int i = left; i <= right; i++) {
			temp[i] = array[i];
		}

		int i = left;
		int j = mid+1;
		int k = left;
		int count = 0;

		while (i <= mid && j <= right){
			if (temp[i] <= temp[j]){
				array[k++] = temp[i++];
			}
			 else {
				 array[k++] = temp[j++];
				 count += (mid -1 +i);
			}
		}
		while (i <= mid) {
			array[k++] = temp[i++];
		}

		// Copy the remaining elements of right sub-array
		while (j <= right) {
			array[k++] = temp[j++];
		}
		return count;
	}

}
