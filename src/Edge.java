public class Edge<T> {
    private final String label;
    private final Vertex<T> from;
    private final Vertex<T> to;
    private final int cost;

    public Edge(String label, Vertex<T> from, Vertex<T> to, int cost){
        this.from = from;
        this.to = to;
        this.label = label;
        this.cost = cost;
    }
}
