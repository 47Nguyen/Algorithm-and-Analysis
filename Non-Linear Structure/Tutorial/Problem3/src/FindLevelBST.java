public class FindLevelBST {
    int level;
    public FindLevelBST(){
        this.level = 0;
    }

    public static void main(String[] args) {
        // Build the tree
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(5);
        root.right = new BinaryTreeNode(20);
        root.left.left = new BinaryTreeNode(2);
        root.left.right = new BinaryTreeNode(7);
        root.right.left = new BinaryTreeNode(15);

        FindLevelBST finder = new FindLevelBST();
        System.out.println(finder.getLevel(root, 5, 0));
    }

    //Get Level
    int getLevel(BinaryTreeNode node, int target, int level){
        if (node == null){
            return -1; // Node node available
        }

        if (node.data == target){
            return level;
        }
        int leftLevel = getLevel(node.left, target, level+1 );
        if (leftLevel != -1) return leftLevel;

        return getLevel(node.right, target, level+1);
    }

    //Get LCA
    BinaryTreeNode getLCA(BinaryTreeNode root, int node1, int node2){
        //We use post-order traversal left, right, root
        if (root == null){
            return null; // If root is empty = whole tree is empty
        }
        if (root.data == node1 || root.data == node2) return root; //Best cae where one of the target is = root, we return

        //The recursive is going to search in depth-first-search prioritising left side, then root, then left side then right side
        BinaryTreeNode leftLca = getLCA(root.left, node1, node2);
        BinaryTreeNode rightLca = getLCA(root.right, node1, node2);

        if (leftLca != null || rightLca != null) return root;
        return (leftLca != null) ? leftLca : rightLca; //If left - sub tree not null return left-sub-tree else right
        /* Another way to write
        if (leftLca != null)
            return leftLca;
        else
            return rightLca;
         */
    }

    //Get distance
    int getDistance(BinaryTreeNode root, int n1, int n2){
        if (root == null) return -1;

        BinaryTreeNode lca = getLCA(root, n1, n2);
        if (lca == null)return -1;

        int level1 = getLevel(lca, n1, 0);
        int level2 = getLevel(lca, n2, 0);

        return level1 + level2; 
    }

}
