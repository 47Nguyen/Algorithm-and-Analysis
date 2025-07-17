import java.io.PrintStream;
import java.util.Arrays;

public class Problem3 {
    public static int numberOfGates(int[][] flights){
        /**
         * Find minimum number of gates required
         * Minimum of 4 gates required (only apply to this certain data)
         */

        int n = flights.length;
        int[] arrivals = new int[n];
        int[] departures = new int[n];



        for (int i = 0; i < n; i++){
            arrivals[i] = flights[i][0];
            departures[i] = flights[i][1];

            /**
             * This loop separate the departure and the arrival time
             * into two different array "arrivals" and "departures" .
             */
        }

        int gatesNeed = 0;
        int maxGates = 0;
        int i =0;
        int j =0;


        Arrays.sort(arrivals);
        Arrays.sort(departures);

        while( i < n && j < n){
            if (arrivals[i] < departures[j]){
                gatesNeed++;
                i++;
                maxGates = Math.max(maxGates, gatesNeed); // Update max if needed
            }
            else {
                gatesNeed--;   // A plane departs
                j++;
            }
        }

        return maxGates;
    }
    public static void main(String[] args) {
        int[][] flights = {
                {100, 110},
                {140, 300},
                {150, 220},
                {200, 230},
                {215, 315},
                {400, 600}
        };
        System.out.println(numberOfGates(flights));
    }
}
