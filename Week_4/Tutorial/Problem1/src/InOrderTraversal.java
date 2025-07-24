public class InOrderTraversal {
    BTNodeLecture root;
    /*
    In-order traversal:
    - Start from left-sub tree
    - Go to node (visit node)
    - Go to right-sub tree
     */

    private void inOrderTraversal(){
        System.out.println("\n In-order traversal recursive: ");
        recursiveInTraversal(root);
    }

    private void recursiveInTraversal(BTNodeLecture node){
        if (node != null){
            recursiveInTraversal(node.left);
            System.out.println(" " + node.data); // Visit node
            recursiveInTraversal(node.right);
        }
    }
}
