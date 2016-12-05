import Lab3Help.Path;
import java.util.*;

public class DijkstraPath<E> implements Path<E> {

    private final List<Vertex<E, Integer>> vertices;
    private List<Edge<E,Integer>> edges;
    private Set<Vertex<E,Integer>> settledVertices;
    private Set<Vertex<E,Integer>> unSettledVertices;
    private Map<Vertex<E,Integer>, Vertex<E,Integer>> predecessors;
    private Map<Vertex<E,Integer>, Integer> distance;


    private List<E> path = new ArrayList<>();
    private final PriorityQueue<Vertex> pq = new PriorityQueue<>();
    private Graph<E, Integer> g;

    public DijkstraPath(Graph<E,Integer> g){
        this.g=g;
        this.vertices = new ArrayList<>(g.getVertices());
        this.edges = new ArrayList<>();

        for (Vertex<E, Integer> v : vertices){
            List<Edge<E,Integer>> currList = v.getOutEdges();
            for(Edge<E,Integer> edge : currList){
                if(!this.edges.contains(edge)){
                    this.edges.add(edge);
                }
            }
        }
    }

    /**
     * Computes the path from <code>from</code> to <code>to</code> (if any). Path
     * information can be retrieved by subsequent calls to
     * <code>getPath()</code> and <code>getPathLength()</code>. It must be
     * possible to call this method any number of times.
     * <p>
     * Precondition: The underlying graph must not contain any negative
     * edge weights.
     *
     * @param fromE
     * @param toE
     */
    @Override
    public void computePath(E fromE, E toE){
        this.settledVertices = new HashSet<>();
        this.unSettledVertices = new HashSet<>();
        this.predecessors = new HashMap<>();
        this.distance = new HashMap<>();

        Vertex from = g.findVertex(fromE);
        Vertex to = g.findVertex(toE);


        distance.put(from, 0);
        unSettledVertices.add(from);

        while(unSettledVertices.size() > 0){
            Vertex<E, Integer> vertex = getMinimum(unSettledVertices);
            settledVertices.add(vertex);
            unSettledVertices.remove(vertex);
            findMinDistances(vertex);
        }

        path = getPath(to);

    }

    private void findMinDistances (Vertex<E, Integer> node){
        List<Vertex<E, Integer>> adjVertices = getAdjacent(node);
        for (Vertex target : adjVertices){
            if (getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target)){
                distance.put(target, getShortestDistance(node) + getDistance(node, target));
                predecessors.put(target, node);
                unSettledVertices.add(target);
            }
        }
    }

    private List<Vertex<E,Integer>> getAdjacent(Vertex<E,Integer> vertex) {
        if(vertex == null) return null;

        List<Vertex<E,Integer>> neighbors = new ArrayList<Vertex<E,Integer>>();
        for (Edge<E,Integer> edge : edges) {
            if (edge.getFrom().equals(vertex) && !isSettled(edge.getTo())) {
                neighbors.add(edge.getTo());
            }
        }
        return neighbors;
    }

    private Vertex<E,Integer> getMinimum(Set<Vertex<E,Integer>> vertices) {
        //return null if vertexes is null
        if(vertices == null) return null;

        Vertex<E,Integer> minimum = null;
        for (Vertex<E,Integer> vertex : vertices) {
            if (minimum == null) {
                minimum = vertex;
            } else {
                if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
                    minimum = vertex;
                }
            }
        }
        return minimum;
    }

    private int getShortestDistance(Vertex<E,Integer> destination) {
        //return 0 if destination is null
        if(destination == null) return 0;

        Integer d = distance.get(destination);
        if (d == null) {
            return Integer.MAX_VALUE;
        } else {
            return d;
        }
    }

    public ArrayList<Vertex<E,Integer>> getPath(Vertex<E,Integer> target) {
        //return null if target is null
        if(target == null) return null;
        //return null if this.edges or this.nodes is null
        if(this.edges == null || this.vertices == null) return null;

        //linked list which will be returned
        ArrayList<Vertex<E,Integer>> path = new ArrayList<Vertex<E,Integer>>();
        Vertex<E,Integer> step = target;
        // check if a path exists
        if (predecessors.get(step) == null) {
            return null; //no path exists
        }
        path.add(step);
        //account for all steps in the path
        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            path.add(step);
        }
        // Put it into the correct order
        Collections.reverse(path);
        return path;
    }

    private boolean isSettled(Vertex<E,Integer> vertex) {
        return settledVertices.contains(vertex);
    }

    private int getDistance (Vertex<E, Integer> node, Vertex<E, Integer> target){
        for (Edge<E,Integer> edge : edges) {
            if (edge.getFrom().equals(node) && edge.getTo().equals(target)) {
                return edge.getCost();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Iterator<E> getPath() {
        return path.iterator();
    }

    /**
     * Returns the length of the computed path, that is, the sum of the
     * weights of each arc on the path.
     * <p>
     * If no path was found the return value is an arbitrary integer. It
     * is appropriate but not required to return a special value such as
     * -1 in this case.
     *
     * @return The length of the computed path.
     */
    @Override
    public int getPathLength() {
        return path.size();
    }
}
