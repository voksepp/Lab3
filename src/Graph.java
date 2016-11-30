import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph<T> {
    private final List<Vertex<T>> vertices;
    private final List<Edge<T>> edges;
    private HashMap<String, Vertex<T>> nameMap;

    public Graph(){
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
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

    public List<Edge<T>> getEdges(){
        return edges;
    }

    public boolean addVertex(Vertex<T> vertex){
        boolean added = false;
        if (!vertices.contains(vertex))
            added = vertices.add(vertex);
            if(added)
                nameMap.put(vertex.getName(), vertex);
        return added;
    }

    public Vertex<T> getVertex (String name){
        return nameMap.get(name);
    }

    public boolean addEdge(Vertex<T> from, Vertex<T> to, int cost){
        Edge<T> edge = new Edge<>(from, to, cost);
        if (!from.outgoingContains(to))
            return false;
        else{
            from.addEdge(edge);
            to.addEdge(edge);
            edges.add(edge);
            return true;
        }
    }
}