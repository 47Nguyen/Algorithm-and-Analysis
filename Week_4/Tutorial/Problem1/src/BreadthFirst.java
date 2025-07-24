
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirst {
    /*
    Breadth-first traversal:
    - Start from root
    - Visit node layer by layer
    - Go left to right
 */
    BTNodeLecture root;
    private void bfTraverse(){
        if (root == null) return;

        Queue<BTNodeLecture> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            BTNodeLecture curr = queue.poll();
            System.out.print(curr.data + " ");

            if (curr.left != null) queue.offer(curr.left);
            if (curr.right != null) queue.offer(curr.right);
        }

    }
}
