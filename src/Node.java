import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class Node<E> {
    public final String name;
    public List<Node> predNodes;
    public List<Node> succNodes;

    public Node(String name){
        this.name = name;
    }

    public void setPredNodes(List<Node> n){  //Skicka in en lista med alla föregående noder.
                                                //Alt. Räkna ut föregående noder här.
        for (Node nd : n){
            predNodes.add(nd);
        }
    }

    public void succNode(List<Node<E>> n){      //Skicka in en lista med alla efterföljande noder.
                                                //Alt. Räkna ut efterföljande noder här.
        for(Node nd : n){
            succNodes.add(nd);
        }

    }
}
