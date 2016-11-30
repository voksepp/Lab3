import Lab3Help.*;
import java.io.IOException;
import java.util.List;

public class Lab3 {

    public static void main (String[] args) throws IOException, MalformedData {
        Lab3File fileParser = new Lab3File();
        List<BStop> stops = fileParser.readStops("stops-gbg.txt");
        List<BLineTable> lines = fileParser.readLines("lines-gbg.txt");
        new GUI(stops, lines, new DijkstraStringPath(stops, lines));
        //Graph graph = new Graph(stops, lines);

    }
}
