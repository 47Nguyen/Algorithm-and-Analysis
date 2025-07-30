package P1;


public class Problem1 {
    // Singly Linked List-based implementation of stack
    static class Node<T> {
        T data;
        Node<T> next;
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    static class LinkedListStack<T> {
        // this class is used as a container of data
        private int size;
        private Node<T> head;


        public LinkedListStack() {
            size = 0;
            head = null;
        }
        public int size() {
            return size;
        }
        public boolean isEmpty() {
            return size == 0;
        }
        public boolean push(T item) {
// add a new node at the beginning
            Node<T> node = new Node<T>(item);
            if (!isEmpty()) {
                node.next = head;
            }
            head = node;
            size++;
            return true;
        }
        public boolean pop() {
// remove the first node
// make sure the stack is not empty
            if (isEmpty()) {
                return false;
            }
// advance head
            head = head.next;
            size--;
            return true;
        }
        public T peek() {
// make sure the stack is not empty
            if (isEmpty()) {
                return null;
            }
            return head.data;
        }
    }

    Node<Integer> head;
    public void removeLLLoop(){
        if (head == null || head.next == null)
            return;
        Node<Integer> slowPointer = head;
        Node<Integer> fastPointer = head;

        //Step 1 - We use Floyd's Algorithm to detect loop
        /**
         * According to Floyd's Algorithm if fast pointer and slow pointer meets at a node at the same time.
         * The loop exists.
         * Note that, fast pointer will move 2 times as fast.
         * We don't need to reset both because moving slow from head and fast from the meeting point
         * ensures they’ll meet exactly at the start of the loop.
         */
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next ;

            if (slowPointer == fastPointer){ //Condition to check if two pointers meet
                break;
            }
        }

        //Step 2 - When the loop node is found we will remove it
        if (slowPointer == fastPointer){
            slowPointer = head;
            /**
             * We only want to set slowPointer back to head position.
             * When loop is found. Both fastPointer and slowPointer will travel 1 step at a time. Eventually,
             * they will meet again.
             * After finding where the loop is, our goal is to find the node of the loop.
             */

            //If loop starts at head
            if (slowPointer == fastPointer){
                while (fastPointer.next != slowPointer){
                    fastPointer = fastPointer.next;
                }
            }
            else {
                while (slowPointer.next != fastPointer.next){
                    slowPointer = slowPointer.next;
                    fastPointer = fastPointer.next;
                }
            }

            //Remove loop
            fastPointer.next = null;
        }
    }
    public static void main(String[] args) {
        Problem1 p = new Problem1();

        // Create a loop manually: 1 → 2 → 3 → 4 → 5 → 3 ...
        Node<Integer> n1 = new Node<>(1);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(3);
        Node<Integer> n4 = new Node<>(4);
        Node<Integer> n5 = new Node<>(5);

        p.head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n3; // loop here

        System.out.println("Loop created. Removing loop...");
        p.removeLLLoop();

        // Print the list to confirm loop is removed
        Node<Integer> current = p.head;
        int count = 0;
        while (current != null && count < 10) { // limit to avoid infinite loop if error
            System.out.print(current.data + " -> ");
            current = current.next;
            count++;
        }
        System.out.println("null");
    }
}
