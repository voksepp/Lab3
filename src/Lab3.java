import Lab3Help.*;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;

public class Lab3 {

    public static void main (String[] args) throws IOException, MalformedData {
        Lab3File fileParser = new Lab3File();
        List<BStop> stops = fileParser.readStops("stops-gbg.txt");
        List<BLineTable> lines = fileParser.readLines("lines-gbg.txt");
        new GUI(stops, lines, new DijkstraStringPath(stops, lines));
        System.out.println(stops);
        System.out.println(lines);

    }

    public void buildGraph(List<BStop> stops, List<BLineTable> lines){

        Graph graph = new Graph();

        for(BLineTable blt : lines){
            for (BStop bst : stops){
                graph.addVertex(new Vertex(stops.toString()));
            }
        }

        /*HashSet<BLineTable> visitedStops = new HashSet<BLineTable>();

        ArrayDeque<BLineTable> stopsStack = new ArrayDeque<BLineTable>();
        stopsStack.add(lines.get(0));

        while (!stopsStack.isEmpty()){
            BLineTable bLT = stopsStack.pop();

            if(!visitedStops.contains(bLT)){
                visitedStops.add(bLT);
                for (Edge edge : graph.getEdges()){ //För varje edge från hållplatsen
                    //Gör edges från hållplatsen bös bös
                    stopsStack.add(edge.getTo());
                }
            }
        }*/
    }

    public void buildGraph2(List<BStop> stops, List<BLineTable> lines){
        Graph g = new Graph();

        for (BStop s : stops){
            g.addVertex(new Vertex(s.getName()));
        }
        for (BLineTable bLT : lines){
            BLineStop[] stopArray = bLT.getStops();
            for (int i = 0; i<stopArray.length; i++){
                g.addEdge(g.getVertex(stopArray[i].getName()), g.getVertex(stopArray[i+1].getName()), stopArray[i+1].getTime());
            }
        }
    }
}
