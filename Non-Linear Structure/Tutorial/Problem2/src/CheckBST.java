import java.util.prefs.PreferenceChangeEvent;

public class CheckBST {
    // Use in order - traversal
    // If the previous value is greater than next value it not BST
    BinaryTreeNode node;
    static Integer previousNode = null; //Start of ass empty
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(20);
        root.left = new BinaryTreeNode(10);
        root.right = new BinaryTreeNode(30);
        root.left.left = new BinaryTreeNode(5);
        root.left.right = new BinaryTreeNode(15);
        root.right.left = new BinaryTreeNode(25);
        root.right.right = new BinaryTreeNode(35);

    }

    static boolean inRecursive(BinaryTreeNode node) {
        if (node == null) return false; //Root is empty

        //Traverse left sub tree
        if (!inRecursive(node)) return false;

        if (previousNode != null && node.data < previousNode){
            return false;
            /*
            If current node is larger than previous node
             */
        }
        previousNode = node.data;

        return inRecursive(node.right);
    }

}

