import Lab3Help.*;

import java.util.ArrayList;
import java.util.List;

public class Graph<T> {
    private List<Vertex<T>> vertices;
    private List<Edge<T>> edges;

    public Graph(){
        vertices = new ArrayList<Vertex<T>>;
        edges = new ArrayList<Edge<T>>();
    }

    public void setStops(){
        for(BStop bSt : stops){
            for(BLineTable bLT : lines){
                if(/*Hållplatsen passeras av den linjen*/){
                    //Gör en edge från den till nästa. Hur hittar
                }
            }
        }
    }
}