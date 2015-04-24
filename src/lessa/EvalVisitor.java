package lessa;

import java.util.HashMap;
import java.util.Map;
import java.io.*;

import envir.Envir;
import envir.Gen;
import envir.Indent;


public class EvalVisitor extends ExprBaseVisitor<String> {
  Map<String, Integer> memory = new HashMap<String, Integer>();//我不知道这是啥！！！
  Indent indent = new Indent();

  public EvalVisitor() throws FileNotFoundException, UnsupportedEncodingException {
    //writer = new PrintWriter("out.py", "UTF-8");
  }


  /** print_stmt: PRINT STRING ;*/
  /**@Override 
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
  }**/
  //single_input -> (stmt)* 
  @Override public String visitSingle_input(ExprParser.Single_inputContext ctx) {
	  System.out.println("single_input" + "\n");
	  int i = 0;
	  String input = "";
	  while(ctx.stmt(i) != null) {
		  input += visit(ctx.stmt(i++)) + " ";
	  }
	  try {
	      //System.out.println("-----------------generating code-----------------\n");
	      Writer w = new FileWriter(Envir.exeFileName, false);
	      w.write(input);
	      w.close();
	      System.out.println("single_input:\n" + input);
	    } catch (IOException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	  return input;
  }
  
  //stmt -> expr_stmt
  @Override public String visitEXPRSTMT(ExprParser.EXPRSTMTContext ctx) {
	  System.out.println("stmt" + "\n");
	  String expression = visit(ctx.expr_stmt());
	  System.out.println("stmt:" + expression + "\n");
	  return expression; 
  }
  
  //stmt -> selection_stmt
  @Override public String visitSELECTSTMT(ExprParser.SELECTSTMTContext ctx) {
	  System.out.println("stmt" + "\n");
	  String expression = visit(ctx.selection_stmt());
	  System.out.println("stmt:" + expression + "\n");
	  return expression; 
  }
  //expr_stmt -> expr_list? ';'
  @Override 
  public String visitExpr_stmt(ExprParser.Expr_stmtContext ctx) {
	  System.out.println("expr_stmt \n");
	  String expr = "";
	  if (ctx.expr_list() != null){
	  expr = visit(ctx.expr_list());
	  }
	  expr += "\n";
	  System.out.println("expr_stmt:" + expr + "\n");
	  return expr; 
  }
 
  //selection_stmt -> 
  @Override 
  public String visitSelection_stmt(ExprParser.Selection_stmtContext ctx) {
	  System.out.println("selection_stmt \n");
	  indent.addIndent();
	  String select = "if " + ctx.test(0).getText() + ":\n" + visit(ctx.stmt(0));
	  System.out.println("selection_stmt:" + select + "\n");
	  return select; 
  }
  //expr_list -> expr (',' expr)*
  public String visitExpr_list(ExprParser.Expr_listContext ctx) {
	  System.out.println("expr_list \n");
	  String expression = visit(ctx.expr(0));
	  int i = 1;
	  while (ctx.expr(i) != null) {
		  expression += " ," + visit(ctx.expr(i++));
	  }
	  return expression;
  }
  
  //expr -> arith_expr
  @Override
  public String visitExpr(ExprParser.ExprContext ctx) {
	  String expression = indent.getIndent() + visit(ctx.arith_expr());
	  return expression;
  }
  //Arith_expr -> term (op=('+'|'-') term)* ;
  @Override 
  public String visitArith_expr(ExprParser.Arith_exprContext ctx) {
	System.out.println("arith_expr");
    String arithstring = visit(ctx.term(0));
    int i = 1;
    while (ctx.term(i) != null) {
    	arithstring += " " + ctx.ADDMINOP(i-1).getText() + " " + visit(ctx.term(i++)); 
    }
    /**try {
      //System.out.println("-----------------generating code-----------------\n");
      Writer w = new FileWriter(Envir.exeFileName, false);
      w.write(arithstring);
      w.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }**/
    System.out.println("arith_expr:" + arithstring);
    return arithstring;
  }
  
//term -> factor (MULDIVOP factor)*
  @Override public String visitFTERM(ExprParser.FTERMContext ctx) {
	  String fac = visit(ctx.factor(0));
	  int i = 1;
	  while (ctx.factor(i) != null) {
		  fac += " " + ctx.MULDIVOP(i-1).getText() + " " + visit(ctx.factor(i++));
	  }
	  return fac;
  }
  
  //term -> tone
  @Override public String visitTTERM(ExprParser.TTERMContext ctx) {
	  return visitChildren(ctx); 
  }
  
//tone -> op=(SHARP|FLAT) atom
  @Override 
  public String visitSFATOMTONE(ExprParser.SFATOMTONEContext ctx) {
	  String sf = ctx.op.getText() + visit(ctx.atom());
	  return sf;
  }
  
  //tone -> atom
  @Override 
  public String visitATOMTONE(ExprParser.ATOMTONEContext ctx) {
	  System.out.println("term->atom \n");
	  return visitChildren(ctx);
  }
  
//factor -> power
  public String visitPMFactor(ExprParser.PMFACTORContext ctx) {
	  System.out.println("factor->power \n");
	  String pwr = ctx.op.getText() + " " + visit(ctx.factor());
	  return pwr;
  }
  
  //factor -> power
  public String visitPWFactor(ExprParser.PWFACTORContext ctx) {
	  System.out.println("factor->power \n");
	  String pwr = visit(ctx.power());
	  return pwr;
  }
  
  //power -> atom_trailer ('**' factor)?
  public String visitPower(ExprParser.PowerContext ctx) {
	  System.out.println("pwr -> at \n");
	  String at = visit(ctx.atom_trailer());
	  return at;
  }
  
  //atom_trailer -> (THIS '.')? atom  (trailer)*;
  public String visitAtom_trailer(ExprParser.Atom_trailerContext ctx) {
	  System.out.println("at->atom \n");
	  String at = "";
	  if (ctx.THIS() != null) {
		  at = "this.";
	  }
	  at += visit(ctx.atom());
	  int i = 0;
	  while (ctx.trailer(i) != null) {
		  at += visit(ctx.trailer(i++));
	  }
	  return at;
  }
  
  //atom -> NAME
  @Override public String visitATOMNAME(ExprParser.ATOMNAMEContext ctx) {
	  String name = ctx.NAME().getText();
	  System.out.println(name + "\n");
	  return name; 
  }
  
  //atom -> NUMBER
  @Override public String visitATOMNUM(ExprParser.ATOMNUMContext ctx) {
	  System.out.println("atom->number");
	  String number = ctx.NUMBER().getText();
	  System.out.println(number + "\n");
	  return number; 
  }
  /**
  @Override
  public String visitTerm(ExprParser.TermContext ctx) { 
	  
	  return visitChildren(ctx); 
  }**/
  
  /**@Override 
  public Integer visitSelection_stmt(ExprParser.Selection_stmtContext ctx){
    System.out.println("start:"+ctx.getRuleContext().getText());
    
    return visitChildren(ctx);
		  
  }**/

}

		
