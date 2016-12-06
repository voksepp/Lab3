import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Graph<E> {

    private final Map<E, Vertex<E>> vMap;
    private final Map<Vertex<E>, List<Edge<E>>> adjList;

    /**
     * THe constructor for the graph object, creates an empty graph. The representation consists of vertices and a map
     * connecting a vertex to a list of edges emanating from it.
     */
    public Graph() {
        vMap = new HashMap<>();
        adjList = new HashMap<>();
    }

    /**
     *
     * @param data usually the name of the vertex
     * @return the vertex
     */
    public Vertex<E> getVertex(E data) {
        Vertex<E> exists = vMap.get(data);
        if (exists != null)
            return exists;
        else
            return null;
    }

    /**
     * Adds a vertex to the graph
     * @param data usually the name of the vertex
     * @return the newly created vertex
     */
    public Vertex<E> addVertex(E data) {
        if (getVertex(data) != null)
            return null;
        Vertex<E> newVertex = new Vertex<>(data);
        vMap.put(data, newVertex);
        adjList.put(newVertex, new ArrayList<>());
        return newVertex;
    }

    /**
     * Adds an edge to the graph
     * @param from The name of the source vertex
     * @param to The name of the destination vertex
     * @param cost the cost/weight of the edge
     * @return true if the edge has been added, false if it already exists
     */
    public boolean addEdge(E from, E to, int cost) {
        if (from.equals(to))
            throw new IllegalArgumentException();
        Vertex<E> fromV = getVertex(from);
        Vertex<E> toV = getVertex(to);

        Edge<E> e = new Edge<>(fromV, toV, cost);
        if (!adjList.get(fromV).contains(e)) {
            adjList.get(fromV).add(e);
            return true;
        }
        return false;
    }

    /**
     * @return the map containing all vertices in the graph
     */
    public Map<E, Vertex<E>> getVertices() {
        return vMap;
    }

    /**
     * @param v A vertex
     * @return All edges emanating from the vertex
     */
    public List<Edge<E>> getOutgoingEdges(Vertex<E> v) {
        return adjList.get(v);
    }
}