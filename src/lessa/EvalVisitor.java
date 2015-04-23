package lessa;

import java.util.HashMap;
import java.util.Map;
import java.io.*;

import envir.Envir;
import envir.Gen;


public class EvalVisitor extends ExprBaseVisitor<Integer> {
  Map<String, Integer> memory = new HashMap<String, Integer>();

  public EvalVisitor() throws FileNotFoundException, UnsupportedEncodingException {
    //writer = new PrintWriter("out.py", "UTF-8");
  }


  /** print_stmt: PRINT STRING ;*/
  @Override 
  public Integer visitPrint_stmt(ExprParser.Print_stmtContext ctx) {
    String print = ctx.PRINT().getText();
    String value = ctx.STRING().getText();

    try {
      //System.out.println("-----------------generating code-----------------\n");
      Writer w = new FileWriter(Envir.exeFileName, false);
      w.write(print);
      w.write(" ");
      w.write(value);
      //System.out.println(print+" "+value);
      w.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return 0;
  }
  @Override 
  public Integer visitExpr_stmt(ExprParser.Expr_stmtContext ctx) { 
    return visitChildren(ctx); 
  }
  @Override 
  public Integer visitSelection_stmt(ExprParser.Selection_stmtContext ctx){
    System.out.println("start:"+ctx.getRuleContext().getText());
    
    return visitChildren(ctx);
		  
  }

}

		
