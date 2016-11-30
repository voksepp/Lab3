import Lab3Help.*;

import java.util.List;

public class Graph {


    //private List<Node> nodes;
    private List<BStop> stops;
    private List<BLineTable> lines;

    public Graph(List<BStop> stops, List<BLineTable> lines){
        this.stops = stops;
        this.lines = lines;
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