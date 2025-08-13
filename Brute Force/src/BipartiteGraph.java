import java.util.Arrays;

public class BipartiteGraph {
    public static void main(String[] args) {

    }

    boolean isBipartite(Graph g){
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        int n = g.n;
        int[] color = new int[n]; //Store values -1
        Arrays.fill(color, -1);

        for (int i = 0; i < n;i++){
            if (color[i] == -1) continue;
            color[i] = 0; // Start the color

            while(!queue.isEmpty()){
                int u = queue.peekFront(); //Retrieve element in front of queue
                queue.deQueue();

                //Start to traverse the graph
                for (int v = 0; v < n;v++){
                    if (color[v] == -1){
                        color[v] = 1 - color[u];
                    } else if (color[v] == color[u]) {
                        return false; // Same color
                    }
                }
            }

        }

        return true;
    }
    static class Graph {
        final int n;
        final boolean[][] adj;

        Graph(int n) {
            this.n = n;
            this.adj = new boolean[n][n];
        }
        void addEdge(int u, int v) {
            if (u == v) return; // self-loop would instantly fail bipartite
            adj[u][v] = true;
            adj[v][u] = true;
        }
    }


}

