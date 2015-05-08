package envir;

import org.antlr.v4.runtime.misc.ParseCancellationException;

public class SyntaxError extends ParseCancellationException{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  public SyntaxError(String message){
    super(message);
  }
}
