import Lab3Help.Path;
import java.util.*;

public class DijkstraPath<E> implements Path<E> {

    private List<E> path;
    private PriorityQueue<Vertex<E>> pq;
    private HashMap<Vertex<E>, Integer> distanceMap;

    public DijkstraPath(Graph<E> g){
        Graph<E> g1 = g;
        path = new ArrayList<E>();
        pq = new PriorityQueue<>(g.getVertices());
        distanceMap = new HashMap<>();
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
        while(pq.isEmpty()){
            Vertex<E> n = pq.remove();
            for (Edge<E> e : n.getOutgoing()){
                Vertex<E> adj = e.getTo();
                Integer newPossibleCost = e.getCost() + distanceMap.get(n);
                if (newPossibleCost < distanceMap.get(adj)){
                    distanceMap.replace(adj, newPossibleCost);
                    pq.remove(adj);
                    pq.add(adj);
                }
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
