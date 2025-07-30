package P3;
public class QueueApplication {
    public static class Event{
        int arrival;
        int duration;
        public Event(int a, int d){
            arrival = a;
            duration = d;
        }
    }

    public static void eventSimulation(){
        ArrayQueue<Event> eventArrayQueue = new ArrayQueue<Event>();
        eventArrayQueue.enQueue(new Event(0, 5));
        eventArrayQueue.enQueue(new Event(3, 3));
        eventArrayQueue.enQueue(new Event(4, 4));
        eventArrayQueue.enQueue(new Event(100, 4));

        int n = eventArrayQueue.size();

        int waiting_time = 0;
        int available_time = 0;
        int max_waiting_time = 0;
        int total_wait = 0;

        while (!eventArrayQueue.isEmpty()){
            Event evt = eventArrayQueue.peekFront(); //returns the node pointed by head
            eventArrayQueue.deQueue(); //Exit from the front
            available_time = Math.max(available_time, evt.arrival);
            max_waiting_time = Math.max(max_waiting_time, waiting_time);
            total_wait += available_time ;
            available_time = available_time + evt.duration;
        }
        System.out.printf("Max waiting time %d, total waiting time %d and average waiting time %.2f\n",
                max_waiting_time, total_wait, 1.0 * total_wait / n);
    }

    public static void main(String[] args) {
        eventSimulation();
    }
}
