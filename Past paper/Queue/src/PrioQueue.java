public class PrioQueue {
    Customer[] customers;
    int size;
    int unhappyCount;
    public PrioQueue(int capacity){
        this.size = 0;
        this.customers = new Customer[capacity];
    }
    public static void main(String[] args) {

    }
    int getValue(String type) {
        if (type.equals("Diamond")) return 3;
        else if (type.equals("Gold")) return 2;
        else return 1;
    }

    int enQueue(Customer customer) {
        if (customer == null) return -1;
        ArrayQueue<Customer> queue = new ArrayQueue<>(); //Starts of empty

        if (queue.isEmpty()){
            queue.enQueue(customer);
            return 0; // 1st Customer
        }
        int pos = 0;

        while (pos < size && getValue(customers[pos].getType()) >= getValue(customer.getType())){
            pos++;
        }

        for (int i = size; i > pos;i--){
            customers[i] = customers[i-1];
        }
        customers[pos] = customer;
        size++;
        for (int i = pos + 1; i < size; i++) {
            if (getValue(customers[i].getType()) < getValue(customer.getType())) {
                unhappyCount++;
            }
        }
        return pos;
    }

    int countUnhappy(){
        return countUnhappy();
    }

    static class Customer {
        int id;
        String name;
        String type;

        public Customer(int id, String name, String type) {
            this.id = id;
            this.name = name;
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "Customer{" + "id=" + id + ", name='" + name + '\'' + ", type='" + type + '\'' + '}';
        }
    }

    static class ArrayQueue<T> {
        // I set a small value to test
// you should replace 10 with a larger value when you use this ADT
        private static final int MAX_SIZE = 10;
        private int size;
        private int front, rear;
        private final T[] items;

        public ArrayQueue() {
            size = 0;
            front = rear = 0;
            items = (T[]) new Object[MAX_SIZE];
        }

        public static void main(String[] args) {
            ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
// enqueue 1 to 9
            for (int i = 1; i <= 9; i++) {
                queue.enQueue(i);
            }
// dequeue 5 times => should get 1 to 5
            for (int i = 0; i < 5; i++) {
                System.out.println(queue.peekFront());
                queue.deQueue();
            }
// enqueue 1 to 5
            for (int i = 1; i <= 5; i++) {
                queue.enQueue(i);
            }
// dequeue until empty()
// should get 6 to 9, then 1 to 5
            while (!queue.isEmpty()) {
                System.out.println(queue.peekFront());
                queue.deQueue();
            }
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

}
