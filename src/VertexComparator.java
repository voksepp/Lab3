import java.util.Comparator;
import java.util.HashMap;

public class VertexComparator<E> implements Comparator<Vertex<E>> {

    public HashMap<Vertex<E>, Integer> d;

    public VertexComparator(HashMap<Vertex<E>, Integer> distances){
        d = distances;
    }

    @Override
    public int compare(Vertex<E> o1, Vertex<E> o2) {
        return d.get(o1)-d.get(o2);
    }
}
