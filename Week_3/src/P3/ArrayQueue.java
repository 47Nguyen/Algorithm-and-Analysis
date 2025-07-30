package P3;

public class ArrayQueue<T> {
    private int size;
    private int front,rear;

    private static int MAX_SIZE = 50;
    private T[] items;

    public ArrayQueue(){
        size = 0;
        front = rear = 0;
        items = (T[]) new Object[MAX_SIZE];
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean enQueue(T item) {
// make sure the queue still have empty slot
        if (size < MAX_SIZE) {
            items[rear] = item;
            rear = (rear + 1) % MAX_SIZE;
            size++;
            return true;
        }
        return false;
    }
    public boolean deQueue() {
    // make sure the queue is not empty
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % MAX_SIZE;
        size--;
        return true;
    }
    public T peekFront() {
    // make sure the queue is not empty
        if (isEmpty()) {
            return null;
        }
        return items[front];
    }

}
