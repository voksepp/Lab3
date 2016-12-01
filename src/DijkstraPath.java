import Lab3Help.Path;
import java.util.*;

public class DijkstraPath<E> implements Path<E> {

    private final List<Vertex<E, Integer>> vertices;
    private List<Edge<E,Integer>> edges;
    private Set<Vertex<E,Integer>> settledNodes;
    private Set<Vertex<E,Integer>> unSettledNodes;
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
     * @param from
     * @param to
     */
    @Override
    public void computePath(E from, E to){
        path.clear();














        /*

        List<Vertex<E>> vertices = g.getVertices();

        for (Vertex v : vertices) {
            v.setDistance(Integer.MAX_VALUE);
        }

        Vertex fromV = (Vertex) from;
        fromV.setDistance(0);
        vertices.remove(from);
        vertices.add(fromV);

        path.add(from);
        pq.addAll(vertices);

        while(!pq.isEmpty()){
            Vertex<E> n = pq.remove();
            for (Edge<E> e : n.getOutgoing()){
                Vertex<E> adj = e.getTo();
                Integer newPossibleCost = e.getCost() + n.getDistance();
                if (newPossibleCost < adj.getDistance()){
                    adj.setDistance(newPossibleCost);
                    pq.remove(adj);
                    pq.add(adj);
                }
            }
        }
        path.add(to);
        */
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
