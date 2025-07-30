
public class BenP2LinkedList {
    public static class Node{
        int data;
        Node head;
        Node next;
        public Node(int data){
            this.data = data;
            this.head = this.next = null;
        }
    }

    Node headRes;
    public BenP2LinkedList(){
        this.headRes = null;
    }

    // Time Complexity is O(N), because we are just traversing the list one by one.
    void mergeList(Node head1, Node head2){
        Node dummy = new Node(0);
        Node current = dummy;

        while (head1 != null && head2 != null){
            /*
            Traverse both list, and compare the data between the two.
            The larger node will go first
             */
            if (head1.data >= head2.data){
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }
        if (head1 != null) {
            current.next = head1;
        } else if (head2 != null) {
            current.next = head2;
        }

        headRes = dummy.next;
    }

    // Time Complexity O(1)
    int maxProduct(){
        if (headRes == null || headRes.next == null){
            return 0;
        }
        return headRes.data * headRes.next.data;
    }

    // Print the List of the Linked List - Time Complexity O(N)
    public void printList(Node head){
        while (head != null){
            System.out.print(head.data);
            if (head.next != null) System.out.print(" ");

            head = head.next;

        }
        System.out.println();
    }
    // Optional: A method to build a linked list from an array (for easy testing)
    public Node buildList(int[] arr) {
        if (arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }
        return head;
    }
    public static void main(String[] args) {
        BenP2LinkedList list = new BenP2LinkedList();
        Node head1 = list.buildList(new int[]{50, 25, 10, 5});
        Node head2 = list.buildList(new int[]{60, 25, 15});

        list.mergeList(head1, head2);

        System.out.print("Merged List: ");
        list.printList(list.headRes);

        int maxProd = list.maxProduct();
        System.out.println("Maximum product of any two nodes: " + maxProd);
    }
}
