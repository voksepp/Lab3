import java.util.Comparator;
import java.util.Map;

class VertexComparator<E> implements Comparator<Vertex<E>> {
    private Map<Vertex<E>, Integer> d;

    /**
     * Comparator for comparing the distance to source between two vertices.
     * @param d Map containing the distances.
     */
    VertexComparator(Map<Vertex<E>, Integer> d) {
        this.d=d;
    }

    /**
     * @param o1 The first vertex
     * @param o2 The second vertex
     * @return Difference in distance
     */
    @Override
    public int compare(Vertex<E> o1, Vertex<E> o2) {
        return d.get(o1) - d.get(o2);
    }
}