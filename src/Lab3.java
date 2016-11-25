import Lab3Help.*;
import java.io.IOException;
import java.util.List;

public class Lab3 {

    public static void main (String[] args) throws IOException, MalformedData {
        Lab3File fileParser = new Lab3File();
        List<BStop> stops = fileParser.readStops(args[0]);
        List<BLineTable> lines = fileParser.readLines(args[1]);
        new GUI(stops, lines, new DijkstraStringPath(stops, lines));
    }
}
