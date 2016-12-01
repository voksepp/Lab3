import Lab3Help.Path;
import java.util.*;

public class DijkstraPath<E> implements Path<E> {

    private final List<Vertex<E, Integer>> vertices;
    private List<Edge<E,Integer>> edges;
    private Set<Vertex<E,Integer>> settledVertices;
    private Set<Vertex<E,Integer>> unSettledVertices;
    private Map<Vertex<E,Integer>, Vertex<E,Integer>> predecessors;
    private Map<Vertex<E,Integer>, Integer> distance;


    private final List<E> path = new ArrayList<E>();
    private final PriorityQueue<Vertex> pq = new PriorityQueue<>();
    private Graph<E, Integer> g;

    public DijkstraPath(Graph<E,Integer> g){
        this.g=g;
        this.vertices = new ArrayList<>(g.getVertices());
        this.edges = new ArrayList<>();

        for (Vertex<E, Integer> v : vertices){
            List<Edge<E,Integer>> currList = v.getOutEdges();
            for(Edge<E,Integer> edge : currList){
                if(!this.edges.contains(edge)){
                    this.edges.add(edge);
                }
            }
        }
    }

    /**
     * Computes the path from <code>from</code> to <code>to</code> (if any). Path
     * information can be retrieved by subsequent calls to
     * <code>getPath()</code> and <code>getPathLength()</code>. It must be
     * possible to call this method any number of times.
     * <p>
     * Precondition: The underlying graph must not contain any negative
     * edge weights.
     *
     * @param fromE
     * @param toE
     */
    @Override
    public void computePath(E fromE, E toE){
        this.settledVertices = new HashSet<>();
        this.unSettledVertices = new HashSet<>();
        this.predecessors = new HashMap<>();
        this.distance = new HashMap<>();

        Vertex from = g.findVertex(fromE);
        Vertex to = g.findVertex(toE);


        distance.put(from, 0);
        unSettledVertices.add(from);

        while(unSettledVertices.size() > 0){
            Vertex<E, Integer> vertex = getMin(unSettledVertices);
            settledVertices.add(vertex);
            unSettledVertices.remove(vertex);
            findMinDistances(vertex);
        }

    }

    private void findMinDistances (Vertex<E, Integer> node){
        List<Vertex<E, Integer>> adjVertices = getNeighbors(node);
        for (Vertex target : adjVertices){
            if (getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target)){
                distance.put(target, getShortestDistance(node) + getDistance(node, target));
                predecessors.put(target, node);
                unSettledVertices.add(target);
            }
        }
    }

    private int getDistance (Vertex<E, Integer> node, Vertex<E, Integer> target){
        for (Edge<E,Integer> edge : edges) {
            if (edge.getFrom().equals(node) && edge.getTo().equals(target)) {
                return edge.getCost();
            }
        }
    }

    @Override
    public Iterator<E> getPath() {
        return path.iterator();
    }

    /**
     * Returns the length of the computed path, that is, the sum of the
     * weights of each arc on the path.
     * <p>
     * If no path was found the return value is an arbitrary integer. It
     * is appropriate but not required to return a special value such as
     * -1 in this case.
     *
     * @return The length of the computed path.
     */
    @Override
    public int getPathLength() {
        return path.size();
    }
}
