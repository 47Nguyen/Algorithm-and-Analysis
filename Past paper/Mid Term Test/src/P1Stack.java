public class P1Stack {
    int[] arrayInt;
    ArrayStack<Integer> stack;
    int[] betweenValues;
    int betweenSize;
    public P1Stack(int[] arrayInt){
        this.arrayInt = arrayInt;
        this.stack = new ArrayStack<>();

    }
    // Array-based implementation of stack
    static class ArrayStack<T> {
        int size;
        static int MAX_SIZE = 100;
        T[] items;
        public ArrayStack() {
            size = 0;
            items = (T[])new Object[MAX_SIZE];
        }
        public int size() {
            return size;
        }
        public boolean isEmpty() {
            return size == 0;
        }
        public boolean push(T item) {
            if (size < MAX_SIZE) {
                items[size] = item;
                size++;
                return true;
            }
            return false;
        }
        public boolean pop() {
            if (isEmpty()) {
                return false;
            }
            size--;
            return true;
        }
        public T peek() {
            if (isEmpty()) {
                return null;
            }
            return items[size - 1];
        }

    }

    void pushStack() {
        betweenValues = new int[arrayInt.length];
        int betweenIndex = 0;
        boolean between = false;
        int count = 0;

        for (int numb : arrayInt) {
            if (numb == 99) {
                count++;
                if (count == 1) {
                    between = true;
                    continue;
                } else if (count == 2) {
                    break;
                }
            } else if (between) {
                // ✅ Fix: this block must be outside the 99 check
                stack.push(numb);
                betweenValues[betweenIndex++]= numb;
            }
        }

        if (count < 2) {
            System.out.println("Invalid input: less than two 99s found.");
        }
    }

    public void printStack() {
        for (int i = 0 ; i < betweenValues.length;i++){
            System.out.println(betweenValues[i]);
        }
    }

    public static void main(String[] args) {
        int[] myArray = {29,7,99,29,5,18,6,99,60};
        P1Stack p1Stack = new P1Stack(myArray);
        p1Stack.pushStack();
        p1Stack.printStack();

    }
}
