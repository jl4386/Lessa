package envir;

import org.antlr.v4.runtime.misc.ParseCancellationException;

public class SymbolError extends ParseCancellationException{

  public SymbolError(String string) {
    super(string);
  }
  
  /**
   * 
   */
  private static final long serialVersionUID = 3887635538408670758L;

}
