public class PreOrderTraversal {
    /*
    Pre-order traversal:
    - Visit node
    - Go from left sub-tree
    - Then go to right-sub tree
     */
    BTNodeLecture root;
    private void traverseRecursive(){
        System.out.println("\n Pre-order traversal recursive: ");
        preRecursive(root);
    }

    private void preRecursive(BTNodeLecture node){
        if (node != null){
            System.out.println(" " + node.data); //visit node
            preRecursive(node.left);
            preRecursive(node.right);
        }
        return;
    }

}
