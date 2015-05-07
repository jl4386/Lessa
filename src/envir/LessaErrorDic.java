package envir;

import java.util.HashMap;

import org.python.core.Py;
import org.python.core.PyObject;

public class LessaErrorDic {
  public static final HashMap<PyObject, LessaError> Exceptions; 
  static {
    Exceptions= new HashMap<PyObject, LessaError>();
    Exceptions.put(Py.NameError, new LessaError("NAME ERROR","00000"));
    Exceptions.put(Py.TypeError, new LessaError("TYPE ERROR","00001"));
    Exceptions.put(Py.FloatingPointError, new LessaError("FLOAT ERROR","00002"));
    Exceptions.put(Py.ZeroDivisionError, new LessaError("DIVDE BY ZERO ERROR","00003"));
    Exceptions.put(Py.IOError, new LessaError("IO ERROR","00004"));
    Exceptions.put(Py.ImportError, new LessaError("IMPORT ERROR","00005"));
    Exceptions.put(Py.ValueError, new LessaError("VALUE ERROR","00006"));
    Exceptions.put(Py.OverflowError, new LessaError("ARITHMETIC ERROR","00007"));
    Exceptions.put(Py.JavaError,new LessaError( "UNDEFINED ERROR","00008"));
    
  }
}
