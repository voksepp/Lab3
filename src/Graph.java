import java.util.*;

public class Graph<V> {

    private Map<V, Vertex<V>> vMap;

    public Graph(){
        vMap = new HashMap<>();
    }

    public int size(){
        return vMap.size();
    }

    public Vertex<V> findNode(V lab) {
        Vertex<V> gotten = vMap.get(lab);
        if(gotten != null) return gotten;
        else return null;
    }

    public Vertex<V> addVertex(V lab)  {
        if(findNode(lab) != null) return null;
        Vertex<V> newGuy = new Vertex<V>(lab);
        vMap.put(lab, newGuy);
        return newGuy;
    }

    public List<Vertex<V>> getVertices() {
        ArrayList<Vertex<V>> vertexList = new ArrayList<>();
        Collection<Vertex<V>> collection = vMap.values();
        Iterator<Vertex<V>> it = collection.iterator();
        while(it.hasNext()){
            vertexList.add(it.next());
        }
        return vertexList;
    }

    public Edge<V> addEdge(V from, int cost, V to){
        if (from.equals(to))
            return null;
        Vertex<V> fromV = findNode(from);
        Vertex<V> toV = findNode(to);

        Edge<V> e = new Edge<V>(fromV, toV, cost);
        fromV.addOutEdge(e);

        return e;
    }


    public boolean addEdge(V source, V target, int cost){

    }
}