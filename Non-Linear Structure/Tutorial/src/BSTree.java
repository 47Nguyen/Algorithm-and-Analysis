public class BSTree {
    BST root;
    int size = 0;
    public boolean insert(int value) {
        if (root == null) root = new BST(value);
        else {
            BST parent = null, current = root;
            while (current != null) {
                if (value < current.data) {
                    parent = current;
                    current = current.left;
                }
                else if (value > current.data) {
                    parent = current;
                    current = current.right;
                }
                else return false;
            // already exists, can’t insert
            }
            if (value < parent.data) {
                parent.left = new BST(value);
                parent.left.parent = parent;
            } else {
                parent.right = new BST(value);
                parent.right.parent = parent;
            }
        }
        size++;
        return true;
        // insert successful
    }


    //In traversal - left, root, right
    private void recursiveInTraversal(BST node){
        if (node != null){
            recursiveInTraversal(node.left);
            System.out.print(" " + node.data); // Visit node
            recursiveInTraversal(node.right);
        }
    }

    //Post traversal, left, right, root
    private void recursivePostOrder(BST node){
        if (node !=null){
            recursivePostOrder(node.left);
            recursivePostOrder(node.right);
            System.out.print(" " + node.data); // Visit node
        }
    }

    //Pre-order, visit node, left, right.
    private void preRecursive(BST node){
        if (node != null){
            System.out.print(" " + node.data); //visit node
            preRecursive(node.left);
            preRecursive(node.right);
        }
    }

    public static void main(String[] args) {
        BSTree bsTree = new BSTree();
        int[] key = {50,20,40,30,60,70};

        for (int v : key){
            bsTree.insert(v);
        }

        bsTree.recursiveInTraversal(bsTree.root);
        System.out.println();
        bsTree.recursivePostOrder(bsTree.root);
        System.out.println();
        bsTree.preRecursive(bsTree.root);
    }
}
