public class knapsack {
    /*
    weight
    capacity
    vertex
     */
    public static void main(String[] args) {

    }

    int getKnapsack(int[] V, int[] W, int n, int C){
        if (n <= 0){
            return 0;
        }
        else if(W[n-1] > C){
            return getKnapsack(V,W,n-1, C);
        } else {
            return Math.max(getKnapsack(V,W,n-1,C), V[n-1] + getKnapsack(V,W, n-1,C - W[n-1])) ;
        }
    }


}
