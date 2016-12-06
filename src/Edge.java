public class Edge<E> {
    private final Vertex<E> from;
    private final Vertex<E> to;
    private final int cost;

    /**
     *
     * @param from
     * @param to
     * @param cost
     */
    public Edge(Vertex<E> from, Vertex<E> to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    /**
     *
     * @return
     */
    public int getCost() {
        return cost;
    }

    /**
     *
     * @return
     */
    public Vertex<E> getTo() {
        return to;
    }

    /**
     *
     * @return
     */
    public Vertex<E> getFrom() {
        return from;
    }
}