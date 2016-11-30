import Lab3Help.*;

import java.util.ArrayList;
import java.util.List;

public class Graph<T> {
    private List<Vertex<T>> vertices;
    private List<Edge<T>> edges;

    private List<T> busStops;
    private List<T> lineTable;

    public Graph(){
        vertices = new ArrayList<Vertex<T>>;
        edges = new ArrayList<Edge<T>>();
    }

    public Graph(List<T> busStops, List<T> lineTable){
        this.busStops = busStops;
        this.lineTable = lineTable;
    }

    public void setStops(){
        for(T bLT : lineTable){
            //Checka vad hållplatserna heter och gör edges
        }
    }
}