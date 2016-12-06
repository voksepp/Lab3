import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<E> {

    private Map<E, Vertex<E>> vMap;
    private Map<Vertex<E>, List<Edge<E>>> adjList;

    public Graph() {
        vMap = new HashMap<>();
        adjList = new HashMap<>();
    }

    public int size() {
        return vMap.size();
    }

    public Vertex<E> getVertex(E data) {
        Vertex<E> exists = vMap.get(data);
        if (exists != null)
            return exists;
        else
            return null;
    }

    public Vertex<E> addVertex(E data) {
        if (getVertex(data) != null)
            return null;
        Vertex<E> newVertex = new Vertex<>(data);
        vMap.put(data, newVertex);
        adjList.put(newVertex, new ArrayList<>());
        return newVertex;
    }

    public boolean addEdge(E from, E to, int cost) {
        if (from.equals(to))
            throw new IllegalArgumentException();
        Vertex<E> fromV = getVertex(from);
        Vertex<E> toV = getVertex(to);

        Edge<E> e = new Edge<>(fromV, toV, cost);
        if (adjList.containsKey(e)){
            if (!adjList.get(fromV).contains(e)) {
                adjList.get(fromV).add(e);
                return true;
            }
        }
        return false;
    }

    public Map<E, Vertex<E>> getVertices() {
        return vMap;
    }

    public void setMax() {
        for (Vertex<E> v : vMap.values()) {
            v.setMax();
        }
    }

    public List<Edge<E>> getOutgoingEdges(Vertex<E> v) {
        return adjList.get(v);
    }
    public List<Vertex<E>> getNextVertices(Vertex<E> v){
        List<Vertex<E>> list = new ArrayList<>();
        for (Edge<E> e : getOutgoingEdges(v)){
            list.add(e.getTo());
        }
        return list;
    }
}