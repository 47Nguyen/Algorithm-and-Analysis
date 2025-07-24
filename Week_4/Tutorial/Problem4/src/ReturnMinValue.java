public class ReturnMinValue {
    BinaryTree root;
    public ReturnMinValue(){
        this.root = null;
    }

    public static BinaryTree searchValue(BinaryTree root, int x){
        BinaryTree candidate = null;
        BinaryTree current = root;

        while (current!= null){
            if (current.data == x){
                return  current;
            } else if (current.data > x){
                candidate = current;
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        ReturnMinValue tree = new ReturnMinValue();
        tree.root = new BinaryTree(10);
        tree.root.left = new BinaryTree(5);
        tree.root.left.right = new BinaryTree(7);
        tree.root.right = new BinaryTree(15);
        tree.root.left.left = new BinaryTree(2);

        int x = 6;
        BinaryTree result = searchValue(tree.root, x);

        if (result != null) {
            System.out.println("Found node with value: " + result.data);
        } else {
            System.out.println("No node with value >= " + x + " found.");
        }
    }
}
