import Lab3Help.Path;

import java.lang.reflect.Array;
import java.util.*;

public class DijkstraPath<E> implements Path<E> {

    private Graph<E> g;
    private List<E> path;
    private PriorityQueue<E> pq;



    public DijkstraPath(Graph<E> g){
        this.g=g;
        path = new ArrayList<E>();
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
    public void computePath(E from, E to) { //Ett test från pseudokoden på http://math.mit.edu/~rothvoss/18.304.3PM/Presentations/1-Melissa.pdf
        List<Vertex<E>> list;
        Stack<E> visitedVertices;
        //TODO: Sätt distance till "from" till 0
        for(Vertex v : g.getVertices()){
            //TODO: Sätt alla andra distance till infinity
        }
        visitedVertices = null; //Behövs denna?
        list = g.getVertices();
        while (!list.isEmpty()){
            //TODO: Vilket element u i aq har kortast distance?
            visitedVertices.add(/*Element u*/);
            for(Vertex v : /*Grannar till u */){
                if(/*Distance[v] > Distance[u] && w(u,v) */){ //Om en ny kortaste väg funnen
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
        }*/
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
        return path.size();
    }
}
