import Lab3Help.*;

import java.io.IOException;
import java.util.List;

public class Lab3 {

    public static void main (String[] args) throws IOException, MalformedData {
        Lab3File lab3File = new Lab3File();
        List<BStop> bStopList = lab3File.readStops(args[0]);
        List<BLineTable> bLineTableList = lab3File.readLines(args[1]);
        // BLineStop stopA =
    }
}
