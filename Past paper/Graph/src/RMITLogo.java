import java.lang.reflect.Array;
import java.util.Arrays;

public class RMITLogo {
    public static void main(String[] args) {

    }

    boolean isBipartite(Graph g){
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        int N = g.n;
        int[] color = new int[N];

        Arrays.fill(color, -1);

        for (int i = 0; i < color.length;i++){
            if (color[i] == -1) return false;
            color[i] =0;
            while (!queue.isEmpty()){
                int u = queue.peekFront();
                queue.deQueue();
                for (int v = 0; v < u;v++){
                    if (color[v] ==-1){
                        color[v] = 1- color[u];
                        return true ;
                    }
                    else if(color[u] == color[v]) return false; //color match not bipartite.
                }
            }
        }
        return true;
    }

    static class Graph {
        final int n;
        final boolean[][] adj;

        public Graph(int n) {
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
