public class BST {
    int data;
    BST parent;
    BST left;
    BST right;

    public BST(int data){
        this.data = data;
        this.parent = left = right = null;
    }
}
