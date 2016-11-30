import Lab3Help.*;
import java.io.IOException;
import java.util.List;

class Lab3 {

    public static void main (String[] args) throws IOException, MalformedData {
        if (args.length != 4)
            throw new IllegalArgumentException("Usage: java Lab3 stops.txt lines.txt HållplatsA HållplatsB");

        Lab3File fileParser = new Lab3File();
        List<BStop> stops = fileParser.readStops("stops-gbg.txt");
        List<BLineTable> lines = fileParser.readLines("lines-gbg.txt");
        Graph g = new Graph(stops, lines);
        DijkstraPath dp = new DijkstraPath(g);

        //new GUI(stops, lines, new DijkstraStringPath(stops, lines));

        String from = args[2];
        String to = args[3];
        Vertex fromStop = g.getVertex(from);
        Vertex toStop = g.getVertex(to);

        dp.computePath(fromStop, toStop);

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
