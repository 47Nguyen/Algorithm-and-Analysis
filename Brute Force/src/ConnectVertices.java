import java.util.ArrayList;

public class ConnectVertices {
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

    //Helpers methods
    boolean insertEdge(Vertex endV, int weight){
    }
}