package Problem1;

import java.util.ArrayList;
import java.util.List;

class Customer {
    int id;
    String name;
    int arrivalOrder;
    String type;
    boolean isUnhappy;

    public Customer(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.isUnhappy = false;
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
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

class BenBankQueue {
    /**
     Queue is FIFO - First in First Out
     */
    private final List<Customer> queue;
    private int arrivalCounter;
    private int unhappyCount;

    public BenBankQueue() {
        queue = new ArrayList<>();
        arrivalCounter = 0;
        unhappyCount = 0;
    }

    private int getPrio(String type){
        switch (type){
            case "Diamond": return 3;
            case "Gold": return 2;
            case "Silver": return 1;
            default: return 0;
        }
    }

    //  enQueue complexity = O(N)
    public int enQueue(Customer customer){
        customer.arrivalOrder = arrivalCounter++;
        int customerPriority = getPrio(customer.type);
        int insertIndex = queue.size();

        for (int i = 0; i < queue.size();i++){
            int existingPriority = getPrio(queue.get(i).type);
                if (customerPriority > existingPriority){
                    insertIndex = i; // Position is also base on its index
                    break;
                }
            }

        //Add new customer into tbe queue
        queue.add(insertIndex, customer);


        //Do a loop to check if any customer is unhappy
        for (int i = insertIndex + 1 ; i < queue.size();i++){
            Customer customerInQueue = queue.get(i);
            if (!customerInQueue.isUnhappy && customerInQueue.arrivalOrder < customer.arrivalOrder &&
                    getPrio(customer.type) > getPrio(customerInQueue.type)){
                customerInQueue.isUnhappy = true;
                unhappyCount++;
            }
        }
        /**
         * Add customer to its corresponding index/queue position
         */
        return insertIndex;
    }

    // deQueue complexity = O(1) - Return customer that will be serve (accessing element in array)
    public Customer deQueue(){
        Customer served = queue.removeFirst(); //Only one customer at a time, always serve the customer in front
        if (queue.isEmpty()){
            return null;
        }

        if (served.isUnhappy){
            unhappyCount--;
        }
        /**
         * If the served customer that Bank finish serving was unhappy, then we remove unhappy counter
         */
        return served; // Return the served customer
    }

    public int getCountUnHappy(){
        return unhappyCount;
    }

    public static void main(String[] args) {
        BenBankQueue bankQueue = new BenBankQueue();
        Customer c1 = new Customer(123,"Joh","Diamond");
        Customer c2 = new Customer(456,"Josh","Gold");
        Customer c3 = new Customer(789,"Jay","Silver");

        System.out.println(bankQueue.enQueue(c2));
        System.out.println(bankQueue.enQueue(c3));
        System.out.println(bankQueue.enQueue(c1));

        System.out.println(bankQueue.deQueue());

        System.out.println("Unhappy Customer: "+bankQueue.getCountUnHappy());

    }

}
