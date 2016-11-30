import java.util.ArrayList;
import java.util.List;

public class Vertex<T>{
    private List<Edge<T>> incoming;
    private List<Edge<T>> outgoing;
    private final String name;
    private boolean visited;

    public Vertex(String name) {
        this.name = name;
        incoming = new ArrayList<>();
        outgoing = new ArrayList<>();
        visited = false;
    }
    public boolean addEdge(Edge<T> edge){
        if(edge.getFrom() == this)
            outgoing.add(edge);
        if(edge.getTo() == this)
            incoming.add(edge);
        else
            return false;
        return true;
    }

    public String getName(){
        return name;
    }

    public List<Edge<T>> getIncoming(){
        return incoming;
    }

    public List<Edge<T>> getOutgoing(){
        return outgoing;
    }

    public boolean getVisited(){
        return visited;
    }

    public void setVisited(){
        visited = true;
    }

    public void clearVisited(){
        visited = false;
    }

    public boolean outgoingContains (Edge<T> edge){
        return outgoing.contains(edge);
    }
    public boolean outgoingContains (Vertex<T> vertex){
        for (Edge<T> edge : outgoing){
            if (edge.getTo() == vertex)
                return true;
        }
        return false;
    }
    public boolean equals(Vertex o) {
        return name.equals(o.getName());
    }
}