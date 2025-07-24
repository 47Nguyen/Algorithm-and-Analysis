public class PostOrderTraversal {
    /*
    Post-order traversal:
    - Start from left-sub tree
    - Go to right-sub tree
    - Visit node
     */

    BTNodeLecture root;
    private void postOrderTraverse(){
        System.out.println("\n Post-order traversal recursive: ");
        recursivePostOrder(root);
    }

    private void recursivePostOrder(BTNodeLecture node){
        if (node !=null){
            recursivePostOrder(node.left);
            recursivePostOrder(node.right);
            System.out.println(" " + node.data); // Visit node
        }
    }

}
