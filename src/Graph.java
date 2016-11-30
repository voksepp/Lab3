import Lab3Help.*;

import java.util.ArrayList;
import java.util.List;

public class Graph<T> {
    private List<Vertex<T>> vertices;
    private List<Edge<T>> edges;

    private List<T> busStops;
    private List<T> lineTable;

    public Graph(){
        vertices = new ArrayList<Vertex<T>>;
        edges = new ArrayList<Edge<T>>();
    }

    public Graph(List<T> busStops, List<T> lineTable){
        this.busStops = busStops;
        this.lineTable = lineTable;
    }

    public void setStops(){
        for(T bLT : lineTable){
            //TODO: Checka vad hållplatserna heter och gör edges

        }
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

    }
}