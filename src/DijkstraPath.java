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

    public void computePath(E from, E to) {
        path.clear();       // förberedelser för ny path
        pq.clear();
        g.setMax();         // sätter alla distance till INF
        totalDistance = Integer.MAX_VALUE;
        HashMap<Integer, Integer> distance = new HashMap<Integer, Integer>();

        destination = g.getVertex(from);        // hittar vertices
        origin = g.getVertex(to);

        origin.setDistance(0);

        pq.add(origin);     // lägger till source i prioritetskön

        while (!pq.isEmpty()) {
            Vertex<E> currentVertex = pq.poll();

            if(!visitedVertices.contains(currentVertex)){
                visitedVertices.add(currentVertex);

                for (Edge<E> nearest : g.getOutgoingEdges(currentVertex)) {
                    //if(!visitedVertices.contains(nearest) )
                    int tmp = currentVertex.getDistance() + nearest.getCost()/*Avståndet mellan currentVertex och nearest*/;
                    if(tmp < nearest.getCost()){
                        /*distance = tmp*/
                        /*kom ihåg att föregångaren till denna nearest är currentVertex*/
                    }
                }
            }
        }


        path.add(origin.getData()); // vertexens namn i path-listan

        /*returnera distance[] och föregångare[]*/
    }

    public void computePath2(E from, E to){
        pq.clear();

        for (Vertex<E> v : g.getVertices().values()){
            v.setDistance(Integer.MAX_VALUE);
            previous.put(v, null);
            pq.add(v);
        }

        origin.setDistance(0);

        while (!pq.isEmpty()){
            Vertex<E> u = pq.poll();
            for (Edge<E> e : g.getOutgoingEdges(u)){
                Vertex<E> v = e.getTo();
                int alt = u.getDistance() + e.getCost();
                if (alt < v.getDistance()){
                    v.setDistance(alt);
                    previous.put(v, u);
                }
            }
        }

        path.clear();
        Vertex<E> u = destination;
        while (previous.get(u) != null){
            path.add(u.getData());
            u = previous.get(u);
        }
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
        if (false) // TODO:fixa villkor
            return -1;
        return destination.getDistance();
    }
}
