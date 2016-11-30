import java.util.ArrayList;

public class Vertex<T> implements Comparable<Vertex>{
    private ArrayList<Vertex<T>> incoming;
    private ArrayList<Vertex<T>> outgoing;
    private final String name;

    public Vertex(String name, ArrayList<Vertex<T>> incoming, ArrayList<Vertex<T>> outgoing) {
        this.name = name;
        this.incoming = incoming;
        this.outgoing = outgoing;
    }
    public boolean addEdge(){

    }

    public String getName(){
        return name;
    }

    public ArrayList<Vertex<T>> getIncoming(){
        return incoming;
    }

    public ArrayList<Vertex<T>> getOutgoing(){
        return outgoing;
    }

    @Override
    public int compareTo(Vertex o) {
        return 0;
    }
}