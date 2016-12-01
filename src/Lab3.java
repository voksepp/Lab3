import Lab3Help.*;
import java.io.IOException;
import java.util.List;

public class Lab3 {

    public static void main (String[] args) throws IOException, MalformedData {
        if (args.length != 4)
            throw new IllegalArgumentException("Usage: java Lab3 stops.txt lines.txt HållplatsA HållplatsB");

        Lab3File fileParser = new Lab3File();
        List<BStop> stops = fileParser.readStops("stops-gbg.txt");
        List<BLineTable> lines = fileParser.readLines("lines-gbg.txt");
        //new GUI(stops, lines, new DijkstraStringPath(stops, lines));

        Graph<Vertex<String>> g = new Graph<>();

        for (BStop s : stops){
            g.addVertex(new Vertex<>(s.getName()));
        }
        for (BLineTable bLT : lines){
            BLineStop[] stopArray = bLT.getStops();
            for (int i = 1; i<stopArray.length; i++){
                g.addEdge(g.getVertex(stopArray[i-1].getName()), g.getVertex(stopArray[i].getName()), stopArray[i].getTime());
            }
        }

        DijkstraStringPath dp = new DijkstraStringPath(g);



        String from = args[2];
        String to = args[3];

        dp.computePath(from, to);

        if(dp.getPathLength() == 0){
            System.out.println("Det finns ingen väg från " + from + " till " + to);
        }
        else if(dp.getPathLength() > 0){
            System.out.println(dp.getPathLength());
            while (dp.getPath().hasNext())
                System.out.println(dp.getPath().next());
        }
        else if(args[2].equals(args[3])){
            System.out.println(0);
            System.out.println(args[2]);
        }
    }
}
