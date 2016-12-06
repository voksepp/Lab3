import Lab3Help.BLineStop;
import Lab3Help.BLineTable;
import Lab3Help.BStop;
import Lab3Help.Path;

import java.util.Iterator;
import java.util.List;

public class DijkstraStringPath implements Path<String> {

    private final DijkstraPath<String> d;

    /**
     * DijkstraStringPath creates a DijkstraPath with Strings
     *
     * @param stops a list of the stops from the text-file
     * @param lines a list of the lines from the text-file
     */
    public DijkstraStringPath(List<BStop> stops, List<BLineTable> lines) {
        Graph<String> g = new Graph<>();

        for (BStop s : stops) {
            g.addVertex(s.getName());
        }
        for (BLineTable bLT : lines) {
            BLineStop[] stopArray = bLT.getStops();
            for (int i = 1; i < stopArray.length; i++) {
                g.addEdge(stopArray[i - 1].getName(), stopArray[i].getName(), stopArray[i].getTime());
            }
        }
        d = new DijkstraPath<>(g);
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
     * @param from the vertex of which to start from
     * @param to   the goal
     */
    @Override
    public void computePath(String from, String to) {
        d.computePath(from, to);
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
    public Iterator<String> getPath() {
        return d.getPath();
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
        return d.getPathLength();
    }
}
