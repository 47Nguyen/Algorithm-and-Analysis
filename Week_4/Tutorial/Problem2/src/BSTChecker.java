class BinaryTree{
    int data;
    BinaryTree left, right;

    public BinaryTree(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class BSTChecker {
    BinaryTree root;
    Integer previousNode = null;

    //Recursive in-order traversal
    private boolean recursiveInTraversal(BinaryTree node){
        if (node != null){

            if (!recursiveInTraversal(node.left)){
                /*
                Traverse left sub-tree because, it an in order traversal.
                Meaning of if loop here means, if left-sub tree is not a BST return false
                 */
                return false;
            }

            //Check BST property
            if(previousNode != null && node.data <= previousNode){
                /*
                For in-order traversal. The value of current node, must be greater than value of previous node.
                If value of current node <= last visit node.
                It terminates.
                 */
                return false;
            }
            previousNode = node.data;
            return recursiveInTraversal(node.right);
            /*
            If the tree still follows is currently still follows in-order traversal.
            It will keep traversing until it finishes the whole tree.
             */
        }
        return true;
    }

    private boolean isBST(){
        previousNode = null;
        return recursiveInTraversal(root);
    }

    public static void main(String[] args) {
        BSTChecker tree = new BSTChecker();

        // Construct a sample binary tree
        tree.root = new BinaryTree(10);
        tree.root.left = new BinaryTree(5);
        tree.root.right = new BinaryTree(15);
        tree.root.left.left = new BinaryTree(2);
        tree.root.left.right = new BinaryTree(7);
        tree.root.right.right = new BinaryTree(20);

        if (tree.isBST()) {
            System.out.println("This is a Binary Search Tree.");
        } else {
            System.out.println("This is NOT a Binary Search Tree.");
        }
    }
}
