import java.lang.reflect.Array;
import java.util.ArrayList;

//Source: https://www.codecademy.com/learn/graph-data-structures-java/modules/graphs-java/cheatsheet
public class ConnectVertices {
}

class Graph{
    int[][] adjMatrix; //2D arr
    int vertex;
    int edges;
    public Graph(int v, int e){
        this.vertex = v;
        this.edges = e;
    }

    boolean addEdge(int v, int u){
      return false;
    }

    public int[][] getAdjMatrix() {
        return adjMatrix;
    }
}

class BFS{
    boolean[] visited;
    public BFS(Graph graph, int start){
        visited = new boolean[graph.getAdjMatrix().length];
    }

    void bfs(Graph graph, int startV){
        ArrayList<Integer> newArr = new ArrayList<>(graph.getAdjMatrix().length);

    }
}

class Vertex{
    String color;
    ArrayList<Edge> edges;
    public Vertex(String color){
        this.color = color;
        this.edges = new ArrayList<Edge>();
    }

    boolean insertEdge(Vertex endV, int weight){
        this.edges.add(new Edge(this, endV, weight));
        return false;
    }


}

class Edge{
    Vertex startV;
    Vertex endV;
    int weight;
    public Edge(Vertex startV, Vertex endV, int weight){
        this.startV = startV;
        this.endV = endV;
        this.weight = -1; //-1 = null
    }

}