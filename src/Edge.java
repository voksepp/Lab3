public class Edge<E> {
    private final Vertex<E> source;
    private final Vertex<E> destination;
    private final int cost;

    /**
     *  Constructor for the Edge class, takes three arguments which are set as class variables
     * @param source source vertex
     * @param destination destination vertex
     * @param cost weight of the edge
     */
    public Edge(Vertex<E> source, Vertex<E> destination, int cost) {
        this.source = source;
        this.destination = destination;
        this.cost = cost;
    }

    /**
     * @return the cost/weight of the edge
     */
    public int getCost() {
        return cost;
    }

    /**
     * @return the destination vertex
     */
    public Vertex<E> getDestination() {
        return destination;
    }

    /**
     * @return the source vertex
     */
    public Vertex<E> getSource() {
        return source;
   }
}