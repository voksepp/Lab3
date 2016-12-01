import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {
    private final T name;
    private List<Edge<T>> outEdges;

    public Vertex(T name) {
        this.name = name;
        outEdges = new ArrayList<>();
    }
    public void addOutEdge(Edge<T> edge){
        outEdges.add(edge);
    }
    public List<Edge<T>> getOutEdges(){
        return outEdges;
    }
    public T getName(){
        return name;
    }
    public String toString(){
        return name.toString();
    }

}