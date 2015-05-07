package envir;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.python.core.Py;
import org.python.core.PyObject;

public class Envir {
  public static final Map<String, Variable> varTable = new LinkedHashMap<String, Variable>();
  public static final Map<String, ImpStmt> defTable = new HashMap<String, ImpStmt>();
  public static final String tempFileName = "definition.py";
  public static final String exeFileName = "exec.py";
  
  public static final String dir = System.getProperty("user.dir")+"/";
  
  
}
