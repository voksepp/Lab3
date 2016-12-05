import Lab3Help.Path;
import java.util.*;

public class DijkstraPath<E> implements Path<E> {

    //private List<Vertex<E, Integer>> vertices;
    //private List<Edge<E,Integer>> edges;
    private List<E> path;
    private PriorityQueue<Vertex<E, Integer>> pq;
    private final Graph<E, Integer> g;
    private Vertex<E, Integer> destination;
    private Vertex<E, Integer> origin;
    private final Map<Vertex<E, Integer>, Integer> distances;

    public DijkstraPath(Graph<E,Integer> g){
        this.g=g;
        distances = new HashMap<>();
        path = new ArrayList<>();
        pq = new PriorityQueue<>();
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

    public void computePath(E from, E to){
        path.clear();
        pq.clear();

        destination = g.getVertex(from);
        origin = g.getVertex(to);

        pq.add(origin);


        while(!pq.isEmpty()){
            //TODO: Stuff

            // använd denna metod: path.add(origin.getV());
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
        return distances.get(destination);
    }
}
