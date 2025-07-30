import java.security.PublicKey;

public class P2LinkedList {
    static class Node{
        int data;
        Node head;
        Node next;
        public Node(int data){
            this.data = data;
            this.head = this.next = null;
        }
    }

    Node headRes;

    void mergeList(Node head1, Node head2){
        Node dummy = new Node(0);
        Node current = dummy;

        while (head1 != null && head2 != null){
            /*
            Traverse both list, and compare the data between the two.
            The larger node will go first
             */
            if (head1.data >= head2.data){
                current = head1;
                head1 = head1.next;
            } else {
                current = head2;
                head2 = head2.next;
            }
            current = current.next;
        }
        headRes = dummy.next;
    }
}
