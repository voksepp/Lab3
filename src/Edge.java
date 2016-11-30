public class Edge<T> {
    private final Vertex<T> from;
    private final Vertex<T> to;
    private final int cost;

    public Edge(Vertex<T> from, Vertex<T> to, int cost){
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
    public Vertex<T> getTo(){
        return to;
    }
    public Vertex<T> getFrom(){
        return from;
    }
}