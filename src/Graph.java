import Lab3Help.*;

import java.util.List;

public class Graph {
    List<BStop> stops;
    List<BLineTable> lines;
    void Graph(List<BStop> stops, List<BLineTable> lines){
        this.stops = stops;
        this.lines = lines;
    }
}
