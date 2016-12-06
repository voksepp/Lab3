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

// --Commented out by Inspection START (2016-12-06 15:15):
//    /**
//     *
//     * @return
//     */
//    public Vertex<E> getFrom() {
//        return from;
//    }
// --Commented out by Inspection STOP (2016-12-06 15:15)
}