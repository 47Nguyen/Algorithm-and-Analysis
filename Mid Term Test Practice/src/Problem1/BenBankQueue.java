package Problem1;

public class BenBankQueue {
    private int size;
    private Customer[] customerList;
    private boolean[] unhappyCustomer;
    private static int capacity = 1000;

    public BenBankQueue(){
        this.size = 0;
        this.customerList = new Customer[capacity];
        this.unhappyCustomer = new boolean[capacity];

    }
    static class Customer{
        int id;
        String name;
        String type;
        public Customer(int id, String name, String type){
            this.id = id;
            this.name = name;
            this.type = type;
        }

        public int getTypeValue(){
            if (type.equals("Diamond")){
                return 3;
            } else if (type.equals("Gold")) {
                return 2;
            }
            else {
                return 1;
            }
        }

        public boolean higherPriority(Customer customer2){
            return getTypeValue() > customer2.getTypeValue(); //Compare value between the two types
        }
    }

    private int enQueue(Customer customer){
        int position = size;
        while (position > 0 && customer.higherPriority(customerList[position-1])){
            customerList[position] = customerList[position-1];
            unhappyCustomer[position] = true;
            unhappyCustomer[position-1] =false;
            position--;
        }
        customerList[position] = customer;
        size++;
        return position;
    }

    private int countUnhappy(){
        int unhappy = 0;
        for (int i= 0 ; i < unhappyCustomer.length;i++){
            if (unhappyCustomer[i]){
                unhappy++;
            }
        }
        return unhappy;
    }

    public static void main(String[] args) {
        BenBankQueue bankQueue = new BenBankQueue();
        System.out.printf("\nAlice (Gold) position: %d", bankQueue.enQueue(new
                Customer(123, "Alice", "Gold")));
        System.out.printf("\nNumber of unhappy: %d", bankQueue.countUnhappy());
        System.out.printf("\nBob (Silver) position: %d", bankQueue.enQueue(new
                Customer(456, "Bob", "Silver"))); // 1 (Bob is positioned after Alice)
        System.out.printf("\nNumber of unhappy: %d", bankQueue.countUnhappy()); // 0 (no
        System.out.printf("\nCarol (Diamond) position: %d", bankQueue.enQueue(new
                Customer(789, "Carol", "Diamond"))); // 0 (Carol has the highest priority)
        System.out.printf("\nNumber of unhappy: %d", bankQueue.countUnhappy()); // 2
        System.out.printf("\nDavid (Gold) position: %d", bankQueue.enQueue(new
                Customer(111, "David", "Gold"))); // 2 (David bypasses Bob)
        System.out.printf("\nNumber of unhappy: %d", bankQueue.countUnhappy()); // 2 (Bob
        
    }
}
