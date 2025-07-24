class BTNodeLecture {
    int data;
    BTNodeLecture left;
    BTNodeLecture right;

    public BTNodeLecture(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class BST {
    static BTNodeLecture root;
    public BST() {
        root = null;
    }

    private static BTNodeLecture find(int x){ //Search for node with x key
        BTNodeLecture node = root;
        while (node != null){
            if (x < node.data) node = node.left;
            else if (x > node.data) node = node.right;
            else return node;
        }

        return null;
    }

    public static void main(String[] args) {
        BTNodeLecture btNode = new BTNodeLecture(7);
        System.out.println(find(7));
    }

}
