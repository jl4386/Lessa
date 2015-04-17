package envir;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Envir {
  public static final Map<String, Variable> varTable = new LinkedHashMap<String, Variable>();
  public static final Map<String, ImpStmt> defTable = new HashMap<String, ImpStmt>();
   
}
