import java.util.Comparator;
import java.util.Map;

class VertexComparator<E> implements Comparator<Vertex<E>> {
    private Map<Vertex<E>, Integer> d;

    VertexComparator(Map<Vertex<E>, Integer> d) {
        this.d=d;
    }

    @Override
    public int compare(Vertex<E> o1, Vertex<E> o2) {
        return d.get(o1) - d.get(o2);
    }
}