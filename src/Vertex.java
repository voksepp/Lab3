import java.util.ArrayList;

public class Vertex<E> implements Comparable<Vertex>{
    private final ArrayList<Vertex> adjList;
    private final String name;

    public Vertex(String name, ArrayList<Vertex> adjList) {
        this.name = name;
        this.adjList = adjList;
    }
    public String getName(){
        return name;
    }

    public ArrayList<Vertex> getAdjList(){
        return adjList;
    }

    @Override
    public int compareTo(Vertex o) {
        return 0;
    }
}
