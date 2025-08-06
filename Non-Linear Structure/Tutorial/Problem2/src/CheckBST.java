public class CheckBST {
    Integer prev = null;
    BinaryTreeNode node;

    boolean isOrder(BinaryTreeNode node){
        prev = null;
        return isBST(node);
    }
    //Use in order traversal
    boolean isBST(BinaryTreeNode node){
        if (node == null){
            return false; // NO node found
        }

        if (!isBST(node.left))return false;

        if (prev != null && node.data <= prev) return false;
        prev = node.data;

        /*
        The next value should always be greater than prev value to make it a BST
         */
        return isBST(node.right);
    }
}

class BinaryTreeNode {
    int data;
    BinaryTreeNode root;
    BinaryTreeNode left, right;

    public BinaryTreeNode(int data) {
        this.data = data;
        this.root = this.left = this.right = null;
    }

}