public class Subset {

    public static void main(String[] args) {
        int[] V = {60, 100, 120}; // values
        int[] W = {10, 20, 30};   // weights
        int C = 50;               // capacity

        int maxValue = knapsack(V, W, C, 0);
        System.out.println("Max value: " + maxValue);
    }

    static int knapsack(int[] V, int[] W, int C, int index) {
        // Base case: no more items or no more capacity
        if (index >= V.length || C <= 0) {
            return 0;
        }

        int skip = knapsack(V, W, C, index + 1);
        int take = 0;
        if (W[index] <= C){
            take = V[index] + knapsack(V, W, C-W[index], index+1);
        }

        return Math.max(skip, take);

    }
}
