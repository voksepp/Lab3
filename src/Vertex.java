import java.util.ArrayList;

public class Vertex<T> implements Comparable<Vertex>{
    private ArrayList<Edge<T>> incoming;
    private ArrayList<Edge<T>> outgoing;
    private final String name;

    public Vertex(String name) {
        this.name = name;
        incoming = new ArrayList<Edge<T>>();
        outgoing = new ArrayList<Edge<T>>();
    }
    public boolean addEdge(Edge<T> edge){
        if(edge.getFrom() == this)
            outgoing.add(edge);
    }

    public String getName(){
        return name;
    }

    public ArrayList<Edge<T>> getIncoming(){
        return incoming;
    }

    public ArrayList<Edge<T>> getOutgoing(){
        return outgoing;
    }

    @Override
    public int compareTo(Vertex o) {
        return 0;
    }
}