package P2;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}
class CircularLinkedList{
    Node head = null;

    //Append function to append new notes
    void append(int data){
        Node newNode = new Node(data);
        if (head == null){
            /**
             * The CLL will always starts out with empty node, so it will first be head = null
             * Then afterwards we want to make it into circular by doing head.next = head, which make it into a
             * circular LL.
             * Afterwards we can just append new data in.
             */
            head = newNode;
            head.next = head;
            return;
        }
        Node temp = head;
        /*
         * We set temp = head so that it create a temporary pointer, at the beginning.
         * Create a placeholder that help to traverse the CLL without modifying the original head value.
         *
         */
        while (temp.next != head) {
            temp = temp.next;
            /*
            Use to traverse the list by moving the temp
            When it reaches the last node in CLL. It will loop back through the hea.
            So the moment temp.next = head, code will stop. As it already loop through the whole thing.
             */
        }

        temp.next = newNode;
        /*
        Use to add new P2.Node.
         */
        newNode.next = head;
        /*
        Point back to our 1st node.
         */
    }

    Node getHead(){
        return head;
    }
}
public class Problem2 {
    public static int getJosephusPosition(int n, int m){
        /**
         * n = length
         * m = the steps
         */

        //Initialize the CLL
        CircularLinkedList cll = new CircularLinkedList();

        // 1. Add data into CLL
        for (int i = 1; i <= n; i++){
            cll.append(i);
        }

        Node current = cll.getHead();
        Node prev = null;

        // 2. Loop the cll, until last person remaining
        while (current.next != current){
            /*
            Loop through the whole list by moving at "m" amount of steps.

            */
            for (int i = 1; i < m; i++){
                /*
                Count starts at 1 because, current is already pointing to the first data already. And count = 1
                will be pointing to the 2nd data.
                m in this for loop will let us take m amount of steps.
                So we will remove every 3rd node.

                Count is the number of steps we've taken. The moment count > m, the loop stops.

                 */
                prev = current;
                current = current.next;
            }
            // Eliminate the m-th person
            System.out.println("Eliminated: " + current.data);
            prev.next = current.next; // Remove current
            current = current.next;   // Move to next person
        }

        // Last remaining person
        System.out.println("Survivor: " + current.data);
        return current.data;

    }

    public static void main(String[] args) {
        int n = 5;
        int m = 3;
        int survivor = getJosephusPosition(n, m);
        System.out.println("Safe Position: " + survivor);
    }

}
