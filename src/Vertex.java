import java.util.ArrayList;
import java.util.List;

public class Vertex<T> implements Comparable<Vertex<T>>{
    private final List<Edge> incoming;
    private final List<Edge> outgoing;
    private final T name;
    private int distance;

    public Vertex(T name) {
        this.name = name;
        incoming = new ArrayList<>();
        outgoing = new ArrayList<>();
        distance = Integer.MAX_VALUE;
    }
    public boolean addEdge(Edge edge){
        if(edge.getFrom() == this)
            outgoing.add(edge);
        if(edge.getTo() == this)
            incoming.add(edge);
        else
            return false;
        return true;
    }

    public T getName(){
        return name;
    }

    public List<Edge> getIncoming(){
        return incoming;
    }

    public List<Edge> getOutgoing(){
        return outgoing;
    }

    public boolean outgoingContains (Edge edge){
        return outgoing.contains(edge);
    }
    public boolean outgoingContains (Vertex<T> vertex){
        for (Edge edge : outgoing){
            if (edge.getTo() == vertex)
                return true;
        }
        return false;
    }
    public boolean equals(Vertex o) {
        return name.equals(o.getName());
    }
    public int getDistance(){
        return distance;
    }

    public void setDistance(int distance){
        this.distance = distance;
    }

    @Override
    public int compareTo(Vertex<T> o) {
        return this.distance - o.getDistance();
    }
}