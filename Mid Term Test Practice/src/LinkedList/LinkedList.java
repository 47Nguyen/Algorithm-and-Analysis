package LinkedList;

public class LinkedList<T> {
    // this class is used as a container of data
    public static class Node<T> {
        public T data;
        public Node<T> next;
        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }
    private int size;
    private Node<T> head;
    public LinkedList() {
        size = 0;
        head = null;
    }
    public int size() {
        return size;
    }
    public void setHead(Node <T> head){
        this.head = head;
    }
    public Node<T> getHead(){
        return head;
    }
    // check whether the linked list is empty or not
    public boolean isEmpty() {
        return size == 0;
    }
    // add a new node at the end
    public void add(T item) {
    // construct a new node
        Node<T> node = new Node<T>(item);
    // if not empty, add new node at the end
        if (!isEmpty()) {
            Node<T> curr = head;
    // position the curr at the end
            while(curr.next != null)
                curr = curr.next;
    // add the new node as the last node
            curr.next = node;
        }else{ // if empty, add new node at the head
            head = node;
        }
        size++;
    }
    // remove the first node
    public T remove() {
    // make sure the linked list is not empty
        if (isEmpty()) {
            System.out.println("Linked list empty.");
            return null;
        }
    // obtain the removed node data
        T removedData = head.data;
    // advance head
        head = head.next;
        size--;
    //return the removed node data
        return removedData;
    }
    // traverse the linked list
    public void traverse(){
    // make sure the linked list is not empty
        if(isEmpty()){
            System.out.println("Linked list empty.");
            return;
        }// use curr node to move around// position curr node initially to the first node// print and advance curr while curr is not null
        Node<T> curr = head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next; // advance curr to the next node
        }
    }
}
