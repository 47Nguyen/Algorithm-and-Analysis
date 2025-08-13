public class FindLevel {
    BinaryTreeNode node;

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(20);
        root.left = new BinaryTreeNode(10);
        root.right = new BinaryTreeNode(30);
        root.left.left = new BinaryTreeNode(5);
        root.left.right = new BinaryTreeNode(15);
        root.right.left = new BinaryTreeNode(25);
        root.right.right = new BinaryTreeNode(35);

        System.out.println(getLevelBst(root, 35,0));

    }


    static int getLevelBst(BinaryTreeNode node, int target, int level){
        if (node == null) return -1;

        if (node.data == target) return level;
        //Traverse the tree
        if (node.data > target){
            return getLevelBst(node.left, target, level+1);
        }

        return getLevelBst(node.right, target,level+1);
    }

    BinaryTreeNode getLCA(BinaryTreeNode node, int n1, int n2){
        if (node == null) return null;

        if (node.data == n1 || node.data == n2) return node; //If the node == root, LCA = root

        if (node.data > n1 && node.data > n2) return getLCA(node.left, n1, n2);
        if (node.data < n2 && node.data < n1){
            return getLCA(node.right, n1, n2);
        }

        return node;
    }
}
