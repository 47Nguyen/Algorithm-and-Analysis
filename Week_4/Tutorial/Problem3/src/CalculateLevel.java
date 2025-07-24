import java.util.LinkedList;
import java.util.Queue;

public class CalculateLevel {
    static BinaryTree root;

    public CalculateLevel(){
        this.root = null;
    }

    public static int checkTreeLevel(BinaryTree node, int target){
        if (root == null){
            /*
            Root level is = 0
             */
            return 1;
        }

        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root); //Offer is enQueue

        int level = 0;

        while (!queue.isEmpty()){
            int size = queue.size(); // Number of nodes at the current level
            for (int i = 0; i < size; i++){
                BinaryTree current = queue.poll();
                if (current.data == target){
                    return level;
                }
                if (current.left != null){
                    queue.add(current.left);
                }
                if (current.right != null){
                    queue.add(current.right);
                }
            }
            level++; // Increment 1 to the level counter and move down the tree (or move to the next level)
        }
        return -1;

    }

    public static void main(String[] args) {
        CalculateLevel tree = new CalculateLevel();

        // Construct a sample binary tree
        tree.root = new BinaryTree(10);
        tree.root.left = new BinaryTree(5);
        tree.root.right = new BinaryTree(15);
        tree.root.left.left = new BinaryTree(2);
        int target = 5;
        int level = checkTreeLevel(root, target);

        if (level != -1) {
            System.out.println("Level of node " + target + ": " + level);
        } else {
            System.out.println("Node " + target + " not found in the tree.");
        }
    }
}
