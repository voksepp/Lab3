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
        //Graph graph = new Graph(stops, lines);

    }

    public void buildGraph(List<BStop> stops, List<BLineTable> lines){

        Graph graph = new Graph();
        ArrayDeque<BLineTable> stopsStack = new ArrayDeque<BLineTable>();
        stopsStack.add(lines.get(0));

        HashSet<BLineTable> visitedStops = new HashSet<BLineTable>();

        while (!stopsStack.isEmpty()){
            BLineTable bLT = stopsStack.pop();
            if(!visitedStops.contains(bLT)){
                visitedStops.add(bLT);
                for (Object edge : graph.getEdges()){ //För varje edge från hållplatsen
                    //Gör edges från hållplatsen bös bös
                }
            }
        }
        for(BLineTable blt : lines){
            //TODO: Gör edges mellan vertices


        }
    }
}
