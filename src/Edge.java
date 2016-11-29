public class Edge {
    private final String label;
    private final Node tail;
    private final Node head;
    private final int cost;

    public Edge(String label, Node tail, Node head, int cost){
        this.tail = tail;
        this.head = head;
        this.label = label;
        this.cost = cost;
    }

}
