import java.util.ArrayList;
import java.util.List;

public class Vertex<V,E> {
    private final V name;
    private List<Edge<V,E>> outEdges;

    public Vertex(V name) {
        this.name = name;
        outEdges = new ArrayList<>();
    }
    public void addOutEdge(Edge<V,E> edge){
        outEdges.add(edge);
    }
    public List<Edge<V,E>> getOutEdges(){
        return outEdges;
    }
    public V getName(){
        return name;
    }
    public String toString(){
        return name.toString();
    }
}