public class Edge implements Comparable<Edge>{
    private final Vertex from;
    private final Vertex to;
    private final int cost;

    public Edge(Vertex from, Vertex to, int cost){
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
    public Vertex getTo(){
        return to;
    }
    public Vertex getFrom(){
        return from;
    }

    @Override
    public int compareTo(Edge o) {
        return this.getCost() - o.getCost();
    }
}