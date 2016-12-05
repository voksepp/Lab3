import java.util.ArrayList;import java.util.List;public class Vertex<V,E> implements Comparable<Vertex<V, E>>{    private final V name;    private int distance;    public Vertex(V name) {        this.name = name;        distance = Integer.MAX_VALUE;    }    public String toString(){        return name.toString();    }    public V getV() {        return name;    }    public int getDistance(){        return distance;    }    @Override    public int compareTo(Vertex<V, E> o) {        return getDistance() - o.getDistance();    }}