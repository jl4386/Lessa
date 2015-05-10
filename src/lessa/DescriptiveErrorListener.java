package lessa;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import envir.SyntaxError;




public class DescriptiveErrorListener extends BaseErrorListener {
    public static DescriptiveErrorListener INSTANCE = new DescriptiveErrorListener();
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
        
        String sourceName = recognizer.getInputStream().getSourceName();
        if (!sourceName.isEmpty()) {
            sourceName = String.format("%s:%d:%d: ", sourceName, line, charPositionInLine);
        }
        StringBuilder sb = new StringBuilder();
        if(offendingSymbol!=null){
          Token t = (Token)offendingSymbol;
          sb.append(" around token '").append(t.getText()).append("'");
        }
        
        throw new SyntaxError("line "+line+":"+charPositionInLine+" "+"\nSyntax Error:"+sb.toString());
        
    }
    
    
    
}

