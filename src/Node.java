import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class Node {
    public final String name;
    public final Map<String, Object> node;

    public Node(Map<String, Object> init){
        node = new HashMap<>(init);
        name = toString(); //FIXME: Overrida toString med egen?? Alt. Ändra denna.
    }

    Object get(String var){
        if(node.containsKey(var)){
            return node.get(var);
        }
        throw new NoSuchElementException();
    }
}
