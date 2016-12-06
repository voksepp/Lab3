public class Edge<E> {
    private final Vertex<E> from;
    private final Vertex<E> to;
    private final int cost;

    public Edge(Vertex<E> from, Vertex<E> to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public Vertex<E> getTo() {
        return to;
    }

    public Vertex<E> getFrom() {
        return from;
    }

    public boolean equals (Edge<E> o){
        return from.equals(o.getFrom()) && to.equals(o.getTo()) && cost == o.getCost();
    }
}