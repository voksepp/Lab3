import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<V, E> {
    private Map<V, Vertex<V>> vMap = new HashMap<>();
    private List<V> vertices;

    public Graph(){
        vertices = new ArrayList<>();
    }

    public boolean isEmpty(){
        return vertices.isEmpty();
    }

    public int size(){
        return vertices.size();
    }

    public List<V> getVertices(){
        return vertices;
    }

    public void addVertex(V vertex){
        if (!vertices.contains(vertex))
            vertices.add(vertex);
    }

    public boolean addEdge(V source, V target, int cost){

    }
}