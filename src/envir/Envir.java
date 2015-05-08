package envir;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class Envir {
  public static final Map<String, Variable> varTable = new LinkedHashMap<String, Variable>();
  public static final Map<String, ImpStmt> defTable = new HashMap<String, ImpStmt>();
  public static final String tempFileName = "definition.py";
  public static final String exeFileName = "exec.py";
  public static final String compileFileName = "output.py";
  public static final String defaultMidiFileName = "output.mid";
  
  public static final String dir = System.getProperty("user.dir")+"/";
  
  
}
