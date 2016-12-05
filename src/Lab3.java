import Lab3Help.*;
import java.io.IOException;
import java.util.List;

public class Lab3 {

    public static void main (String[] args) throws IOException, MalformedData {
        if (args.length != 4)
            throw new IllegalArgumentException("Usage: java Lab3 stops.txt lines.txt HållplatsA HållplatsB");

        Lab3File fileParser = new Lab3File();
        List<BStop> stops = fileParser.readStops(args[0]);
        List<BLineTable> lines = fileParser.readLines(args[1]);
        String from = args[2];
        String to = args[3];
        //new GUI(stops, lines, new DijkstraStringPath(stops, lines));

        DijkstraStringPath dsp = new DijkstraStringPath(stops, lines);

        dsp.computePath(from, to);

        if(dsp.getPathLength() == 0){
            System.out.println("Det finns ingen väg från " + from + " till " + to);
        }
        else if(dsp.getPathLength() > 0){
            System.out.println(dsp.getPathLength());
            while (dsp.getPath().hasNext())
                System.out.println(dsp.getPath().next());
        }
        else if(args[2].equals(args[3])){
            System.out.println(0);
            System.out.println(args[2]);
        }
    }
}
