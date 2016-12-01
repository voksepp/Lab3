public class Edge<V,E>{
    private final Vertex<V,E> from;
    private final Vertex<V,E> to;
    private final E cost;

    public Edge(Vertex<V,E> from, Vertex<V,E> to, E cost){
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    public E getCost() {
        return cost;
    }
    public Vertex<V,E> getTo(){
        return to;
    }
    public Vertex<V,E> getFrom(){
        return from;
    }
}