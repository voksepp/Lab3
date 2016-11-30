import Lab3Help.*;

import java.util.ArrayList;
import java.util.List;

public class Graph<T> {
    private List<Vertex<T>> vertices;
    private List<Edge<T>> edges;

    public Graph(){
        vertices = new ArrayList<Vertex<T>>;
        edges = new ArrayList<Edge<T>>();
    }

    public Graph(List<Vertex<T>> vertices, List<Edge<T>> edges){
        this.vertices = vertices;
        this.edges = edges;
    }

    public boolean isEmpty(){
        return vertices.isEmpty();
    }

    public int size(){
        return vertices.size();
    }

    public List<Vertex<T>> getVertices(){
        return vertices;
    }

    public boolean addVertex(Vertex<T> vertex){
        boolean added = false;
        if (!vertices.contains(vertex))
            added = vertices.add(vertex);
        return added;
    }

    public boolean addEdge(Vertex<T> from, Vertex<T> to, int cost){
        Edge<T> edge = new Edge<T>(from, to, cost);
        if (from.getEdges(to) != null)
            return false;
        else{
            from.addEdge(edge);
            to.addEdge(edge);
            edges.add(edge);
            return true;
        }
    }
}