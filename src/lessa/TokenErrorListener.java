package lessa;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import envir.SymbolError;
import envir.SyntaxError;




public class TokenErrorListener extends BaseErrorListener {
    public static TokenErrorListener INSTANCE = new TokenErrorListener();
    private static final boolean REPORT_SYNTAX_ERRORS = true;
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg, RecognitionException e)throws ParseCancellationException 
                              
                            
    {
        System.out.println();
        if (!REPORT_SYNTAX_ERRORS) {
            return;
        }
        
        
        //System.out.println(recognizer.getInputStream().LA(-1));
        
        StringBuilder sb = new StringBuilder();
        
          //Token t = (Token)offendingSymbol;
          
          sb.append("line ").append(line).append(":").append(charPositionInLine);
          sb.append("\nUnrecognized Token ");
          
          sb.append(parseMessage(e.toString())).append("");
        
        throw new SymbolError(sb.toString());
        
    }
    private static String parseMessage(String message){
      String re =message.substring("LexerNoViableAltException(".length());
      re =re.replace(")","");
      return re;
    }
    
    
}

