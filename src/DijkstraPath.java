import Lab3Help.Path;
import java.util.*;

public class DijkstraPath<E> implements Path<E> {

    private final List<Vertex<E, Integer>> vertices;
    private List<Edge<E,Integer>> edges;
    private List<E> path = new ArrayList<>();
    private final PriorityQueue<Vertex> pq = new PriorityQueue<>();
    private Graph<E, Integer> g;
    private Vertex<E, Integer> destination;
    private Vertex<E, Integer> origin;

    private Map<Vertex<E,Integer>, Integer> distances;

    public DijkstraPath(Graph<E,Integer> g){
        this.g=g;
        this.vertices = new ArrayList<>(g.getVertices());
        this.edges = new ArrayList<>();

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

    }
}
