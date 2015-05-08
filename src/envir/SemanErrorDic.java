package envir;

import java.util.HashMap;

import org.python.core.Py;
import org.python.core.PyObject;

public class SemanErrorDic {
  public static final HashMap<PyObject, SenmanticError> Exceptions; 
  static {
    Exceptions= new HashMap<PyObject, SenmanticError>();
    Exceptions.put(Py.NameError, new SenmanticError("NAME ERROR","00000"));
    Exceptions.put(Py.TypeError, new SenmanticError("TYPE ERROR","00001"));
    Exceptions.put(Py.FloatingPointError, new SenmanticError("FLOAT ERROR","00002"));
    Exceptions.put(Py.ZeroDivisionError, new SenmanticError("DIVDE BY ZERO ERROR","00003"));
    Exceptions.put(Py.IOError, new SenmanticError("IO ERROR","00004"));
    Exceptions.put(Py.ImportError, new SenmanticError("IMPORT ERROR","00005"));
    Exceptions.put(Py.ValueError, new SenmanticError("VALUE ERROR","00006"));
    Exceptions.put(Py.OverflowError, new SenmanticError("ARITHMETIC ERROR","00007"));
    Exceptions.put(Py.JavaError,new SenmanticError( "UNDEFINED ERROR","00008"));
    
  }
}
