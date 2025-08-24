public class FindTreeLevel {
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

		// Test getTreeNode
		System.out.println("Level of 6: " + getLevel(root, 6, 0));
		System.out.println("Level of 2: " + getLevel(root, 2, 0));
		System.out.println("Level of 8: " + getLevel(root, 8, 0));
		System.out.println("Level of 1: " + getLevel(root, 1, 0));
		System.out.println("Level of 4: " + getLevel(root, 4, 0));

		// Test getLCA
		System.out.println("LCA of 1 and 4: " + getLCA(root, 1, 4).data);
		System.out.println("LCA of 2 and 8: " + getLCA(root, 2, 8).data);
		System.out.println("LCA of 7 and 9: " + getLCA(root, 7, 9).data);

		// Test Distance
		System.out.println("Distance of 1 and 8: " + getDistance(root, 1, 8));
		System.out.println("Distance of 2 and 8: " + getDistance(root, 2, 6));
	}
	static int getDistance(TreeNode node, int node1, int node2){
		TreeNode lca = getLCA(node, node1, node2);

		//Get level
		int level1 = getLevel(node, node1, 0);
		int level2 = getLevel(node, node2, 0);
		int lcaLevel = getLevel(node, lca.data, 0);

		return (level1-lcaLevel) + (level2 -lcaLevel);
	}
	static int getLevel(TreeNode node, int target, int level){
		if (node == null){
			return -1;
		}

		if (target < node.data){
			return getLevel(node.left, target, level+1);
		}
		else if (target > node.data){
			return getLevel(node.right, target, level +1);
		}
		else {
			return level;
		}

	}

	static TreeNode getLCA(TreeNode root, int node1, int node2){
		if (root == null) return null;  // Safety check

		if (node1 < root.data && node2 < root.data){
			root = root.left;
			return getLCA(root, node1, node2);
		} else if (node1 > root.data && node2 > root.data) {
			root = root.right;
			return getLCA(root.right, node1, node2);
		} else {
			return root;

		}
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
