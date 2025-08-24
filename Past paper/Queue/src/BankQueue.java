public class BankQueue {
    Customer[] customers;
    int size;
    int unhappy;
    public BankQueue(){
        this.size = 0;
        this.unhappy =0;
        this.customers = new Customer[100];
    }

    int getPriority(String type){
        if (type.equals("Diamond")) return 3;
        else if (type.equals("Gold")) return 2;
        else return 0;
    }

    int enQueue(Customer customer){
        int pos = size;

        for(int i = 0; i < size;i++){
            if (getPriority(customers[i].getType()) < getPriority(customer.getType())){
                pos = i; //Found the index when the if conditions is met
                unhappy++; // customer found unhappy
                break;
            }
        }

        for (int i = size; i > pos;i--){
            customers[i] = customers[i-1];
        }

        customers[pos] = customer;
        size++;
        return pos;
    }

    int countUnhappy(){
        return unhappy;
    }

    static class Customer{
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
            return "Customer{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", type='" + type + '\'' +
                    '}';
        }
    }
}
