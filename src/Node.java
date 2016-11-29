import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class Node<E> {
    public final String name;
    public final Map<String, Object> node;
    public List<Node<E>> predNodes;
    public List<Node<E>> succNodes;

    public Node(Map<String, Object> init){
        node = new HashMap<>(init);
        name = toString(); //FIXME: Overrida toString med egen?? Alt. Ändra denna. Är den ens nödvändigt? Vad är meningen med livet?
    }

    Object get(String var){
        if(node.containsKey(var)){
            return node.get(var);
        }
        throw new NoSuchElementException();
    }

    public void setPredNodes(List<Node<E>> n){
        for (Node<E> nd : n){
            predNodes.add(nd);
        }
    }

    public void succNode(List<Node<E>> n){
        for(Node<E> nd : n){
            succNodes.add(nd);
        }

    }
}
