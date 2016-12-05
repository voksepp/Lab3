import java.util.*;

public class Graph<V,E> {

    private Map<V, Vertex<V,E>> vMap;
    private Map<Vertex<V,E>, List<Vertex<V,E>>> adjList;

    public Graph(){
        vMap = new HashMap<>();
    }

    public int size(){
        return vMap.size();
    }

    public Vertex<V,E> getVertex(V lab) {
        Vertex<V,E> exists = vMap.get(lab);
        if(exists != null) return exists;
        else return null;
    }

    public Vertex<V,E> addVertex(V name)  {
        if(getVertex(name) != null) return null;
        Vertex<V,E> newVertex = new Vertex<>(name);
        vMap.put(name, newVertex);
        return newVertex;
    }

    public Edge<V,E> addEdge(V from, V to, E cost){
        if (from.equals(to))
            return null;
        Vertex<V,E> fromV = getVertex(from);
        Vertex<V,E> toV = getVertex(to);

        Edge<V,E> e = new Edge<>(fromV, toV, cost);

        return e;
    }
}