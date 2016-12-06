import Lab3Help.BLineTable;
import Lab3Help.BStop;
import Lab3Help.Lab3File;
import Lab3Help.MalformedData;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Lab3 {

    /**
     * Calculates and prints the shortest path along bus lines between two stops.
     *
     * @param args Usage: java Lab3 stops.txt lines.txt HållplatsA HållplatsB
     *             This is written in the console
     * @throws IOException   Signals that an I/O exception of some sort has occurred.
     * @throws MalformedData Constructs an exception with a given error message.
     */
    public static void main(String[] args) throws IOException, MalformedData {
        if (args.length != 4)
            throw new IllegalArgumentException("Usage: java Lab3 stops.txt lines.txt HållplatsA HållplatsB");

        Lab3File fileParser = new Lab3File();
        List<BStop> stops = fileParser.readStops(args[0]);
        List<BLineTable> lines = fileParser.readLines(args[1]);
        String from = args[2];
        String to = args[3];

        DijkstraStringPath dsp = new DijkstraStringPath(stops, lines);

        dsp.computePath(from, to);
        int pathLength = dsp.getPathLength();

        if (pathLength == -1) {
            System.out.println("Det finns ingen väg från " + from + " till " + to);
        } else if (pathLength >= 0) {
            System.out.println(dsp.getPathLength());
            Iterator<String> i = dsp.getPath();
            while (i.hasNext())
                System.out.println(i.next());
        }
    }
}
