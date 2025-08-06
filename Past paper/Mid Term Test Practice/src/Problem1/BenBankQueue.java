package Problem1;

public class BenBankQueue {
    /**
     * For this part, we don't need to implement the array Queue;
     * But instead what we can do is just store the Object customer in a list, then access directly from there.
     */
    Customer[] customerQueue;
    int size;
    int capacity = 100;
    boolean[] unhappy;
    public BenBankQueue(){
        this.size = 0;
        customerQueue = new Customer[capacity];
        unhappy = new boolean[capacity];
    }

    public static void main(String[] args) {
        BenBankQueue bq = new BenBankQueue();
        Customer c1 = new Customer("A",123,"Diamond");
        Customer c2 = new Customer("B",456,"Gold");
        Customer c3 = new Customer("C",789,"Silver");

        System.out.println(bq.enQueue(c2));
        System.out.println(bq.enQueue(c3));
        System.out.println(bq.enQueue(c1));

        System.out.println(bq.countUnhappy());

    }

    int getValue(String type){
        if (type.equals("Diamond")) return 3;
        else if (type.equals("Gold")) return 2;
        else if(type.equals("Silver")) return 1;
         else return 0;
    }


    int enQueue(Customer c){
        int newC = getValue(c.getType());
        int position = size; // Available positions
        for (int i = 0; i < size;i++){
            int currentC = getValue(customerQueue[i].getType());
            if (currentC < newC){ //Compare priority
                position = i;
                break;
            }

        }
        for (int i = size; i > position;i--){
            /*
            Decrementing because with the queue is FIFO.
            So we want to compare the value from the last of the queue, then going forwards the queue.
            We set i = size, because that's at the end of the queue. New elements enter at the end of Q
            Every time the loop is run, i is going to decrease by one.
            The for loop will stops running when i < position.
             */
            customerQueue[i] = customerQueue[i-1];
            /*
            This will override the position of the index,
            Since We are going to add new element, the size is going to increase by 1?
            If index = 4, has greater priority than index 3.
            Index 3 will become 4. => customerQueue[4] = customerQueue[4-1] this actions is overriding.
             */
            unhappy[i] = unhappy[i - 1];
        }
        customerQueue[position] = c;
        unhappy[position] = false;

        // Mark everyone who got pushed back as unhappy
        for (int i = position + 1; i <= size; i++) {
            unhappy[i] = true;
        }
        size++;
        /*
        Increase size by one because we have added a new element
         */
        return position;
    }

    int countUnhappy(){
        int count = 0;
        for (int i = 0; i < size; i++){
            if (unhappy[i]) {
                count++;
            }
        }
        return count;
    }


    static class Customer{
        String name;
        int id;
        String type;
        public Customer(String name, int id, String type){
            this.name = name;
            this.type = type;
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", type='" + type + '\'' +
                    '}';
        }
    }

}
