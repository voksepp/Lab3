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

    public Graph(List<Vertex<T>> vertecies, List<Edge<T>> edges){
        this.vertices = vertecies;
        this.edges = edges;
    }

    public void setStops(){
        for(T bLT : lineTable){
            //TODO: Checka vad hållplatserna heter och gör edges

        }
    }

    public boolean isEmpty(){
        return vertices.isEmpty();
    }

    public boolean addVertex(Vertex<T> vertex){
        boolean added = false;

        if (!vertices.contains(vertex))
            added = vertices.add(vertex);

        return added;
    }
}