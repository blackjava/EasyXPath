package xml.xpath;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.w3c.dom.Node;
import xml.xpath.axis.Child;
import xml.xpath.axis.Self;

/**
 *
 */
public abstract class Axis {
    private static final Map<String, Class<Axis>> axes = new HashMap<>();

    static {
        Axis.add("self", Self.class);
        Axis.add("child", Child.class);
    }
    
    
    public static Axis get(String axisName) throws UnknownAxisException {    
        try {
            Class<Axis> axis = axes.get(axisName);

            if (axis == null) {
                throw new UnknownAxisException(axisName);
            }

            return axis.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new UnknownAxisException(axisName);
        }
    }
    
    public static void add(String axisName, Class<? extends Axis> implementationClass) {
        axes.put(axisName, (Class<Axis>)implementationClass);
    }

    public abstract List<Node> apply(Node node);
}
