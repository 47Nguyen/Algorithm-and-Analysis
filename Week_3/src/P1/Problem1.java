package P1;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}
public class Problem1 {
    Node head;

    public void removeLLLoop(){
        if (head == null || head.next == null)
            return;
        Node slowPointer = head;
        Node fastPointer = head;

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
            fastPointer = fastPointer.next;

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
            fastPointer = null;
        }
    }
    public static void main(String[] args) {

    }
}
