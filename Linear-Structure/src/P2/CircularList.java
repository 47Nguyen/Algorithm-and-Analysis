package P2;

public class CircularList {
    int size;
    Node head, tail;

    public CircularList(int size ){
        this.size = 0;
        head = tail = null;
    }

    public void add2End(int value) {
        Node n = new Node(value);
        if (size == 0) {
            head = tail = n;
        } else {
            tail.next = n;
        }
        tail = n;
        n.next = head;
        size++;
    }
    // remove the node passed to the method
    public void removeNode(Node c) {
        if (size == 0) {
            return;
        }
// decide the preceding node
        Node t = head;
        while (t.next != c) {
            t = t.next;
        }
        if (c == head) {
            head = c.next;
        }
        if (c == tail) {
            tail = t;
        }
        t.next = t.next.next;
        size--;
    }
}

