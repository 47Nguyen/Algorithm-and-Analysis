public class P2LinkedList {
    Node headRes;

    public static void main(String[] args) {
        P2LinkedList t = new P2LinkedList();
        Node h1 = new Node(50);
        h1.next = new Node(25);
        h1.next.next = new Node(10);
        h1.next.next.next = new Node(5);

        Node h2 = new Node(60);
        h2.next = new Node(25);
        h2.next.next = new Node(15);

        t.mergeList(h1, h2);
        System.out.println(t.maxProduct());
    }
    void mergeList(Node n1, Node n2){
        Node dummy = new Node(0);
        Node tail = dummy;
        while (n1 != null && n2 != null){
            if (n1.data >= n2.data) {
                tail.next = n1;
                n1 = n1.next; //Move to the next data in the node 1 after compared/
            }
             else{
                tail.next = n2;
                n2 = n2.next;
            }
             tail = tail.next; //Move to the next node in the tail.
        }

        headRes = dummy.next;
        printList(headRes);
    }


    int maxProduct(){
        if (headRes == null) return -1;

        return headRes.data * headRes.next.data;
    }
    void printList(Node node){
        if (node == null) System.out.println("Null");

        Node curr = node;
        while(curr != null){
            System.out.print(curr.data + " -> "); //Print data
            curr = curr.next; //Move on to the next next data;
        }
        System.out.println("null");
    }
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
}
