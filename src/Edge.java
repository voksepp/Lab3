public class Edge<V> implements Comparable<Edge>{
    private final Vertex<V> from;
    private final Vertex<V> to;
    private final int cost;

    public Edge(Vertex<V> from, Vertex<V> to, int cost){
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
    public Vertex<V> getTo(){
        return to;
    }
    public Vertex<V> getFrom(){
        return from;
    }

    @Override
    public int compareTo(Edge o) {
        return this.getCost() - o.getCost();
    }
}