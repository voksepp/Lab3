import java.util.*;

public class Graph<V,E> {

    private Map<V, Vertex<V,E>> vMap;

    public Graph(){
        vMap = new HashMap<>();
    }

    public int size(){
        return vMap.size();
    }

    public Vertex<V,E> findNode(V lab) {
        Vertex<V,E> gotten = vMap.get(lab);
        if(gotten != null) return gotten;
        else return null;
    }

    public Vertex<V,E> addVertex(V lab)  {
        if(findNode(lab) != null) return null;
        Vertex<V,E> newGuy = new Vertex<>(lab);
        vMap.put(lab, newGuy);
        return newGuy;
    }

    public List<Vertex<V,E>> getVertices() {
        ArrayList<Vertex<V,E>> vertexList = new ArrayList<>();
        Collection<Vertex<V,E>> collection = vMap.values();
        Iterator<Vertex<V,E>> it = collection.iterator();
        while(it.hasNext()){
            vertexList.add(it.next());
        }
        return vertexList;
    }

    public Edge<V,E> addEdge(V from, E cost, V to){
        if (from.equals(to))
            return null;
        Vertex<V,E> fromV = findNode(from);
        Vertex<V,E> toV = findNode(to);

        Edge<V,E> e = new Edge<>(fromV, toV, cost);
        fromV.addOutEdge(e);

        return e;
    }
}