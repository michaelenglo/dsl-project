package cpsc.dlsproject.tools;

import java.util.HashMap;
import java.util.Map;

public class VariableMap {

    public static final Map<String, Variable> variables = new HashMap<>();

    public static Map<String, Variable> getVariableMap(){
        return variables;
    }
}
