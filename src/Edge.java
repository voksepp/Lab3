class Edge<E> {
    private final Vertex<E> tail;
    private final Vertex<E> head;
    private final int cost;

    /**
     * Constructor for the Edge class, takes three arguments which are set as class variables
     *
     * @param tail tail vertex
     * @param head head vertex
     * @param cost weight of the edge
     */
    public Edge(Vertex<E> tail, Vertex<E> head, int cost) {
        this.tail = tail;
        this.head = head;
        this.cost = cost;
    }

    /**
     * @return the cost/weight of the edge
     */
    public int getCost() {
        return cost;
    }

    /**
     * @return the head vertex
     */
    public Vertex<E> getHead() {
        return head;
    }

    /**
     * @return the tail vertex
     */
    public Vertex<E> getTail() {
        return tail;
    }
}