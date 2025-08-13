// Array-based implementation of stack
public class ArrayStack<T> {
    private static final int MAX_SIZE = 100;
    private final T[] items;
    private int size;

    public ArrayStack() {
        size = 0;
        items = (T[]) new Object[MAX_SIZE];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean push(T item) {
        // make sure the stack still have empty slot
        if (size < MAX_SIZE) {
            items[size] = item;
            size++;
            return true;
        }
        return false;
    }

    public T pop() {
        if (isEmpty()) return null;
        T val = items[--size];
        items[size] = null; // avoid loitering
        return val;
    }

    public T peek() {
        // make sure the stack is not empty
        if (isEmpty()) {
            return null;
        }
        return items[size - 1];
    }


}
