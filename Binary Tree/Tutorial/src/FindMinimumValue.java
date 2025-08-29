public class FindMinimumValue {
	public static void main(String[] args) {
		// Create simple BST:    6
		//                     /   \
		//                    2     8
		//                   / \   / \
		//                  1   4 7   9

		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);

		System.out.println(getMinValue(root, 8));
	}
	static TreeNode getMinValue(TreeNode root, int X){
		if (root == null){
			return null;
		}
		if (root.data == X){
			return root;
		}

		TreeNode foundNode = null;
		TreeNode current = root;

		while (current != null){
			if (current.data > X){
				foundNode = current;
				current = current.left;
			}
			else {
				current = current.right;
			}
		}
		return foundNode;
	}

	static class TreeNode{
		int data;
		TreeNode root, left, right;
		public TreeNode(int data){
			this.data = data;
			root = left = right = null;
		}
	}
}
