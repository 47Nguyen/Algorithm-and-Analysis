package P3;

import java.util.Arrays;

public class Problem3 {
    public static double[] findMaxAverage(int n, int[] arrival, int [] duration){

        // Only sort arrival time array
        Arrays.sort(arrival);

        /*
        Do not sort the duration because every person has different duration and sorting
        will ruin the corresponding of it.
         */

        int maxTime = 0;
        double averageTime = 0;
        int current_time = 0;
        int start_time = 0;
        int[] waiting_time = new int[n];
        int sumWaiting = 0;
        double[] result = new double[2];

        for (int i = 0; i < n;i++){
            if (arrival[i] >= current_time){
                waiting_time[i] = 0;
                start_time = arrival[i];
            }
            else {
                start_time = current_time;
                waiting_time[i] = current_time - arrival[i];
            }
            //Update current time
            current_time = start_time + duration[i];

        }

        for (int i = 0; i < waiting_time.length; i++) {
            maxTime = Math.max(maxTime, waiting_time[i]);
        }


        //Calculation for average time
        for (int time : waiting_time){
            sumWaiting += time;
        }
        averageTime = (double) sumWaiting / waiting_time.length;
        result[0] = maxTime;
        result[1] = averageTime;

        return result;
    }

    public static void main(String[] args) {
        // Simulated input
        int[] arrival = {0, 2, 4, 5};      // Sorted
        int[] duration = {5, 2, 3, 1};     // Usage times
        int n = arrival.length;

        double[] result = findMaxAverage(n, arrival, duration);

        System.out.println("Simulation Results:");
        System.out.println("Maximum Waiting Time: " + result[0] + " minutes");
        System.out.println("Average Waiting Time: " + result[1] + " minutes");
    }
}
