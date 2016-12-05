import java.util.ArrayList;
import java.util.List;

public class Vertex<V,E> {
    private final V name;

    public Vertex(V name) {
        this.name = name;
    }
    public String toString(){
        return name.toString();
    }
}