import Lab3Help.Path;

import java.util.*;

public class DijkstraPath<E> implements Path<E> {

    private final Graph<E> g;
    private List<E> path;
    private PriorityQueue<Vertex<E>> pq;
    private Vertex<E> destination;
    private Vertex<E> origin;
    private int totalDistance;
    private HashSet<Vertex<E>> visitedVertices = new HashSet<>();
    private HashMap<Vertex<E>, Vertex<E>> previous = new HashMap();

    /**
     *
     * @param g
     */
    public DijkstraPath(Graph<E> g) {
        this.g = g;
        path = new ArrayList<>();
        pq = new PriorityQueue<>();
    }

    public void computePath(E from, E to){
        pq.clear();
        path.clear();
        destination = g.getVertex(to);
        origin = g.getVertex(from);

        if (from.equals(to)){
            path.add(from);
            return;
        }

        for (Vertex<E> v : g.getVertices().values()){
            v.setDistance(Integer.MAX_VALUE);
            previous.put(v, null);
        }

        origin.setDistance(0);

        pq.add(origin);

        while (!pq.isEmpty()){
            Vertex<E> u = pq.poll();
            for (Edge<E> e : g.getOutgoingEdges(u)){
                Vertex<E> v = e.getTo();
                int alt = u.getDistance() + e.getCost();
                if (alt < v.getDistance()){
                    v.setDistance(alt);
                    previous.put(v, u);
                    if (!pq.contains(v))
                        pq.add(v);
                }
            }
        }


        Vertex<E> u = destination;
        while (previous.get(u) != null){
            path.add(u.getData());
            u = previous.get(u);
        }
        path.add(origin.getData());
        Collections.reverse(path);
    }

    /**
     * Returns an iterator over the nodes in the path.
     * <p>
     * If a path has been found the first node in the iterator is the
     * argument <code>from</code> passed to <code>computePath</code> and
     * the last node is <code>to</code>.
     * <p>
     * If no path was found or if no call to computePath has been made the
     * iterator is empty.
     *
     * @return An iterator over the computed path.
     */
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
        if (destination.getDistance() == Integer.MAX_VALUE)
            return -1;
        return destination.getDistance();
    }
}
