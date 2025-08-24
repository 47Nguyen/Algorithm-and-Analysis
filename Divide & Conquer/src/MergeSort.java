import java.util.LinkedHashMap;
import java.util.Random;

public class MergeSort {
	static LL headRef;
	public static void main(String[] args) {
		Random rand = new Random();
		int[] array = new int[1000];

		for (int i = 0; i < array.length;i++){
			array[i] = rand.nextInt(1000000);
		}
//		 Step 1: Sort array
		mergeSort(array);

//		 Step 2: Convert sorted array into Balanced BST
		BSTNode root = convertToBST(array, 0, array.length - 1);

		// Step 3: Print inorder traversal to verify
		inorder(root); // should print sorted array
	}


	static void mergeSort(int[] array){
		int n = array.length;
		if (n < 2 ){
			return;
		}

		// Mid point
		int mid = n/2;
		//Sub array left
		int[] left = new int[mid];
		//Sub array right
		int[] right = new int[n-mid];

		for (int i = 0; i < mid; i++) {
			left[i] = array[i];
		}
		for (int i = mid; i < n; i++) {
			right[i - mid] = array[i];
		}

		mergeSort(left);
		mergeSort(right);
		merge(array, left, right);
	}

	static void merge(int[] array, int[] leftArr, int[] rightArr){
		int leftSize = leftArr.length;
		int rightSize = rightArr.length;

		int i = 0, j = 0, k = 0;

		// k = combined left and right

		while(i < leftSize && j < rightSize){
			if (leftArr[i] <= rightArr[j]){
				array[k] = leftArr[i];
				i++;
			}
			else {
				array[k] = rightArr[j];
				j++;
			}
			k++;
		}

		// This while loop triggers if there are left values in left array
		while (i < leftSize){
			array[k] = leftArr[i];
			i++;
			k++;
		}

		// This while loop triggers if there are left values in right array
		while(j < rightSize){
			array[k] = rightArr[j];
			j++;
			k++;
		}
	}

	// Problem 2A
	static BSTNode convertToBST(int[] array, int start, int end){
		if (start > end){
			return null;
		}

		int midVal = (end+start) / 2;
		BSTNode node =  new BSTNode(array[midVal]);

		node.left = convertToBST(array, start, midVal-1);
		node.right = convertToBST(array, midVal+1, end);

		return node;
	}

	// Problem 2B
	static LL sortedLinkedListToBST(LL head){
		headRef = head;
		return head; // Not done
	}

	static BSTNode sortedListToBSTHelper(int n){
		if (n <= 0) return null;

		BSTNode left = sortedListToBSTHelper(n/2);

		// Root
		BSTNode root = new BSTNode(headRef.data);
		root.left = left;

		// Move head forward
		headRef = headRef.next;

		root.right = sortedListToBSTHelper(n- n/2 -1);
		return root;
	}
	static int countNodes(LL head) {
		int count = 0;
		while (head != null) {
			count++;
			head = head.next;
		}
		return count;
	}

	static class BSTNode{
		int data;
		BSTNode root;
		BSTNode left, right;
		public BSTNode(int data){
			this.data = data;
			this.root= left = right = null;
		}
	}

	static class LL{
		int data;
		LL head;
		LL tail;
		LL next;
		public LL(int data){
			this.data = data;
			head = tail = next = null;
		}
	}

	static void inorder(BSTNode node) {
		if (node == null) return;
		inorder(node.left);
		System.out.print(node.data + " ");
		System.out.println();
		inorder(node.right);
	}

}
