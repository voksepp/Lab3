import Lab3Help.Path;
import java.util.*;

public class DijkstraPath<E> implements Path<E> {

    private Graph<E> g;
    private List<E> path;
    private PriorityQueue<Vertex<E>> pq;
    private HashMap<Vertex<E>, Integer> distanceMap;



    public DijkstraPath(Graph<E> g){
        this.g=g;
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
    /*public void computePath(E from, E to) { //Ett test från pseudokoden på http://math.mit.edu/~rothvoss/18.304.3PM/Presentations/1-Melissa.pdf
        List<Vertex<E>> list = g.getVertices();
        Stack<E> visitedVertices;
        for(Vertex v : list){
            distanceMap.put(v, Integer.MAX_VALUE);
        }
        distanceMap.put((Vertex<E>) from, 0);

        visitedVertices = null; //Behövs denna?

        while (!list.isEmpty()){
            //TODO: Vilket element u i list har kortast distance?
            visitedVertices.add(Element u);
            for(Vertex v : Grannar till u *{
                if(Distance[v] > Distance[u] && w(u,v) ){ //Om en ny kortaste väg funnen
                    //v = u + w(uv);
                }
            }
        }
        //Returnera dist?



        /*while (!prioritetskön.isEmpty()) {
            if (from.equals(to)) {
                path.add(from);
                return;
            } else {
                for (Vertex v : g.getVertices()) {
                    if (v.getOutgoing().equals(to)) {
                        //path.add();
                        return;
                    }
                }
            }
        }/*
    }
/*


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
        return path.size();
    }
}
