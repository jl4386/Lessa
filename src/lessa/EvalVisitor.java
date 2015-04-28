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
	  System.out.println("single_input -> (stmt)* ");
	  int i = 0;
	  String input = "";
	  while(ctx.stmt(i) != null) {
		  input += visit(ctx.stmt(i++)) + "\n";
	  }
	  try {
	      //System.out.println("-----------------generating code-----------------\n");
	      Writer w = new FileWriter(Envir.exeFileName, false);
	      w.write(input);
	      w.close();
	      System.out.println("final written single_input:");
	      System.out.println(input);
	    } catch (IOException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	  return input;
  }
  
  //stmt -> expr_stmt
  @Override public String visitEXPRSTMT(ExprParser.EXPRSTMTContext ctx) {
	  System.out.println("stmt -> expr_stmt");
	  String expression = indent.getIndent() + visit(ctx.expr_stmt());
	  System.out.println("stmt -> expr_stmt return:\n" + expression);
	  return expression; 
  }
  
  //stmt -> compound_stmt
  @Override public String visitCOMPSTMT(ExprParser.COMPSTMTContext ctx) {
	  System.out.println("stmt -> compound_stmt");
	  String ret = visit(ctx.compound_stmt());
	  System.out.println("stmt -> compound_stmt return:\n" + ret);
	  return ret;
  }
  
  //stmt -> selection_stmt
  @Override public String visitSELECTSTMT(ExprParser.SELECTSTMTContext ctx) {
	  System.out.println("stmt -> selection_stmt");
	  //indent.addIndent();
	  String expression = visit(ctx.selection_stmt());
	  //indent.delIndent();
	  System.out.println("stmt -> selection_stmt:\n" + expression);
	  return expression; 
  }
  
  //stmt: iteration_stmt
  @Override public String visitITRSTMT(ExprParser.ITRSTMTContext ctx) { 
	  System.out.println("stmt -> iteration_stmt");
	  String expression = visit(ctx.iteration_stmt());
	  System.out.println("stmt -> iteration_stmt:\n" + expression);
	  return expression;
  }
  
  //stmt: assign_stmt
  @Override public String visitASSIGNSTMT(ExprParser.ASSIGNSTMTContext ctx) { 
	  System.out.println("stmt -> assign_stmt");
	  String ret = indent.getIndent() + visit(ctx.assign_stmt()) + "\n";
	  System.out.println("stmt -> assign_stmt return:\n" + ret);
	  return ret;
  }
  
  //stmt: jump_stmt 
  @Override public String visitJMPSTMT(ExprParser.JMPSTMTContext ctx) { 
	  System.out.println("stmt -> jump_stmt");
	  String ret = indent.getIndent() + visit(ctx.jump_stmt()) + "\n";
	  System.out.println("stmt -> jump_stmt return:\n" + ret);
	  return ret;
  }
  
  //jump_stmt: break_stmt 
  @Override public String visitBJMP(ExprParser.BJMPContext ctx) { 
	  return visit(ctx.break_stmt());
  }
  
  //jump_stmt: continue_stmt
  @Override public String visitCJMP(ExprParser.CJMPContext ctx) { 
	  return visit(ctx.continue_stmt());
  }
  
  //jump_stmt: return_stmt
  @Override public String visitRJMP(ExprParser.RJMPContext ctx) { 
	  return visit(ctx.return_stmt());
  }
  
  //break_stmt: BREAK ';'  
  @Override public String visitBreak_stmt(ExprParser.Break_stmtContext ctx) {
	  return ctx.BREAK().getText();
  }
  
  //continue_stmt: CONTINUE ';' ;
  @Override public String visitContinue_stmt(ExprParser.Continue_stmtContext ctx) { 
	  return ctx.CONTINUE().getText();
  }
  
  //return_stmt: RETURN (test_list)? ';' 
  @Override public String visitReturn_stmt(ExprParser.Return_stmtContext ctx) { 
	  return ctx.RETURN().getText();
  }
  
  //compound_stmt:'{' (stmt_list)? '}' ;
  @Override public String visitCompound_stmt(ExprParser.Compound_stmtContext ctx) {
	  System.out.println("compound_stmt -> '{' (stmt_list)? '}'");
	  String ret = "";
	  if (ctx.stmt_list() != null) {
		  ret += visit(ctx.stmt_list());
	  }
	  return ret;
  }
  
  //stmt_list: stmt_list stmt
  @Override public String visitLISTLISTSTMT(ExprParser.LISTLISTSTMTContext ctx) { 
	  System.out.println("stmt_list -> stmt_list stmt");
	  String ret = visit(ctx.stmt_list())  + visit(ctx.stmt());
	  return ret;
  }
  
  //stmt_list: stmt
  @Override public String visitLISTSTMT(ExprParser.LISTSTMTContext ctx) {
	  System.out.println("stmt_list -> stmt");
	  String ret = visit(ctx.stmt());
	  return ret;
  }
  
  //assign_stmt:expr assign_operators expr ';' ;
  @Override public String visitAssign_stmt(ExprParser.Assign_stmtContext ctx) { 
	  System.out.println("assign_stmt:expr assign_operators expr ';'");
	  String ret = visit(ctx.expr(0)) + " " + visit(ctx.assign_operators()) +  " " + visit(ctx.expr(1));
	  System.out.println("assign_stmt return:" + ret);
	  return ret;
  }
  
  //assign_operators: ASSIGN
  @Override public String visitASSIGNOP(ExprParser.ASSIGNOPContext ctx) {
	  return ctx.ASSIGN().getText();
  }
  
  //assign_operators: PLUSASSIGN
  @Override public String visitPASSIGNOP(ExprParser.PASSIGNOPContext ctx) {
	  return ctx.PLUSASSIGN().getText();
  }
  
  //assign_operators: MINUSASSIGN
  @Override public String visitMASSIGNOP(ExprParser.MASSIGNOPContext ctx) { 
	  return ctx.MINUSASSIGN().getText();
  }
  
  //assign_operators: TIMESASSIGN
  @Override public String visitTASSIGNOP(ExprParser.TASSIGNOPContext ctx) {
	  return ctx.TIMESASSIGN().getText();
  }
  
  //assign_operators: DIVIDEASSIGN
  @Override public String visitDASSIGNOP(ExprParser.DASSIGNOPContext ctx) { 
	  return ctx.DIVIDEASSIGN().getText();
  }
  
  //selection_stmt -> IF '(' test ')' stmt (ELIF '(' test ')' stmt)* (ELSE stmt)?
  @Override 
  public String visitSelection_stmt(ExprParser.Selection_stmtContext ctx) {
	  System.out.println("selection_stmt -> IF '(' test ')' stmt (ELIF '(' test ')' stmt)* (ELSE stmt)?");
	  //String select = "if " + ctx.test(0).getText() + ":\n" + visit(ctx.stmt(0));
	  String select = indent.getIndent() + "if " + visit(ctx.test(0)) + ":\n";
	  indent.addIndent();
	  select += visit(ctx.stmt(0));
	  indent.delIndent();
	  int i = 1;
	  while (ctx.test(i) != null) {
		  select += indent.getIndent() + "elif " + visit(ctx.test(i)) + ":\n";
		  indent.addIndent();
		  select += visit(ctx.stmt(i));
		  indent.delIndent();
		  i++;
	  }
	  if (ctx.stmt(i) != null) {
		  select += indent.getIndent() + "else" + ":\n";
		  indent.addIndent();
		  select += visit(ctx.stmt(i));
		  indent.delIndent();
	  }
	  System.out.println("selection_stmt return:\n" + select);
	  return select; 
  }
  
  //iteration_stmt: while_stmt
  @Override public String visitWILEITR(ExprParser.WILEITRContext ctx) { 
	  System.out.println("iteration_stmt->while_stmt");
	  return visit(ctx.while_stmt());
  }
  
  //iteration_stmt: for_stmt
  @Override public String visitFORITR(ExprParser.FORITRContext ctx) { 
	  System.out.println("iteration_stmt->for_stmt");
	  return visit(ctx.for_stmt());
  }
  
  //while_stmt: WHILE '(' test ')' stmt
  @Override public String visitWhile_stmt(ExprParser.While_stmtContext ctx) {
	  System.out.println("while_stmt -> WHILE '(' test ')' stmt");
	  String ret ="while " + visit(ctx.test()) + ":" + "\n";
	  indent.addIndent();
	  ret += visit(ctx.stmt());
	  indent.delIndent();
	  System.out.println("while_stmt return:");
	  System.out.println(ret);
	  return ret;
  }
  
  //for_stmt: FOR '(' expr_list IN test_list ')' stmt 
  @Override public String visitFor_stmt(ExprParser.For_stmtContext ctx) {
	  System.out.println("for_stmt -> FOR '(' expr_list IN test_list ')' stmt");
	  indent.addIndent();
	  String ret = "for" + " " + visit(ctx.expr_list()) + " " + "in" +  " " 
	  + visit(ctx.test_list()) + ":" + "\n" +  visit(ctx.stmt());
	  indent.delIndent();
	  System.out.println("for_stmt return:" + ret);
	  return ret;
  }
  
  //test_list: test (',' test)* 
  @Override public String visitTest_list(ExprParser.Test_listContext ctx) { 
	  System.out.println("test_list -> test (',' test)* ");
	  String ret = visit(ctx.test(0));
	  int i = 1;
	  while (ctx.test(i) != null) {
		  ret += "," + visit(ctx.test(i));
		  i++;
	  }
	  return ret;
  }
  
  //test: or_test (IF or_test ELSE test)?
  @Override public String visitTest(ExprParser.TestContext ctx) { 
	  System.out.println("test -> or_test (IF or_test ELSE test)?");
	  String ret = null;
	  ret = visit(ctx.or_test(0));
	  if (ctx.or_test(1) != null) {
		  ret += "if " + visit(ctx.or_test(1)) + "else " + visit(ctx.test());
	  }
	  System.out.println("test return:" + ret);
	  return ret;
  }
  
  //or_test: and_test (OR and_test)* ;
  @Override public String visitOr_test(ExprParser.Or_testContext ctx) { 
	  System.out.println("or_test -> and_test (OR and_test)*");
	  String ret = null;
	  ret = visit(ctx.and_test(0));
	  int i = 1;
	  while(ctx.and_test(i) != null) {
		  ret += "or " + visit(ctx.and_test(i));
		  i++;
	  }
	  //System.out.println("or_test return:" + ret);
	  return ret;
  }
  
  //and_test: not_test (AND not_test)* ;
  @Override public String visitAnd_test(ExprParser.And_testContext ctx) { 
	  System.out.println("and_test -> not_test (AND not_test)*");
	  String ret = null;
	  ret = visit(ctx.not_test(0));
	  int i = 1;
	  while(ctx.not_test(i) != null) {
		  ret += "and " + visit(ctx.not_test(i));
		  i++;
	  }
	  //System.out.println("and_test return:" + ret);
	  return ret;
  }
  
  //not_test: NOT not_test  |   comparison ;
  @Override public String visitNot_test(ExprParser.Not_testContext ctx) { 
	  String ret = null;
	  if (ctx.getChildCount() == 2) {
		  System.out.println("not_test -> NOT not_test");
		  ret = "not " + visit(ctx.not_test()); 
		  //System.out.println("not_test -> NOT not_test return:" + ret);
	  } else {
		  System.out.println("not_test -> comparison");
		  ret = visit(ctx.comparison());
		  //System.out.println("not_test -> comparison return:" + ret);
	  }
	  return ret;
  }

  //comparison: arith_expr (comp_op arith_expr)* ;
  @Override public String visitComparison(ExprParser.ComparisonContext ctx) { 
	  System.out.println("comparison -> arith_expr (comp_op arith_expr)*");
	  String ret = "";
	  ret += visit(ctx.arith_expr(0)) + " ";
	  int i = 1;
	  while(ctx.arith_expr(i) != null) {
		  ret += visit(ctx.comp_op(i-1)) + " ";
		  ret += visit(ctx.arith_expr(i)) + " ";
		  i++;
	  }
	  System.out.println("comparison return: " + ret);
	  return ret;
  }
  
  /*comp_op: '<'|'>'|'=='|'>='|'<='|'<>'|'!='
	|	IN   |	NOT IN   |	IS   |	IS NOT ;
   */
  @Override public String visitComp_op(ExprParser.Comp_opContext ctx) { 
	  String text = ctx.getText();
	  String ret = null;
	  switch (text) {
	  	case "<":
	  		//System.out.println("comp_op -> '<'");
	  		ret = "<";
	  		break;
	  	case ">":
	  		//System.out.println("comp_op -> '>'");
	  		ret = ">";
	  		break;
	  	case "==":
	  		//System.out.println("comp_op -> '=='");
	  		ret = "==";
	  		break;
	  	case ">=":
	  		//System.out.println("comp_op -> '>='");
	  		ret = ">=";
	  		break;
	  	case "<=":
	  		//System.out.println("comp_op -> '<='");
	  		ret = "<=";
	  		break;
	  	case "<>":
	  		//System.out.println("comp_op -> '<>'");
	  		ret = "<>";
	  		break;
	  	case "!=":
	  		//System.out.println("comp_op -> '!='");
	  		ret = "!=";
	  		break;
	  	case "in":
	  		//System.out.println("comp_op -> IN");
	  		ret = "in";
	  		break;
	  	case "is":
	  		//System.out.println("comp_op -> IS");
	  		ret = "is";
	  		break;
	  	case "isnot":
	  		//System.out.println("comp_op -> IS NOT");
	  		ret = "is not";
	  		break;
	  	case "notin":
	  		//System.out.println("comp_op -> NOT IN");
	  		ret = "not in";
	  		break;
	  	default:
	  		//System.out.println("So what is it ?:" + text);
	  		break;
	  }
	  return ret;
  }
  

  
  //expr_stmt -> expr_list? ';'
  @Override 
  public String visitExpr_stmt(ExprParser.Expr_stmtContext ctx) {
	  //System.out.println("expr_stmt \n");
	  String expr = "";
	  if (ctx.expr_list() != null){
	  expr = visit(ctx.expr_list());
	  }
	  expr += "\n";
	  //System.out.println("expr_stmt:" + expr + "\n");
	  return expr; 
  }
  
  //expr_list -> expr (',' expr)*
  public String visitExpr_list(ExprParser.Expr_listContext ctx) {
	  //System.out.println("expr_list \n");
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
	  //String expression = indent.getIndent() + visit(ctx.arith_expr()); // Why indent here ? 
	  //System.out.println("expr -> arith_expr");
	  String expression = visit(ctx.arith_expr());
	  return expression;
  }
  
  //arith_expr -> term (op=('+'|'-') term)* ;
  @Override 
  public String visitArith_expr(ExprParser.Arith_exprContext ctx) {
	//System.out.println("Arith_expr -> term (op=('+'|'-') term)*");
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
    //System.out.println("Arith_expr return:" + arithstring);
    return arithstring;
  }
  
//term -> factor (MULDIVOP factor)*
  @Override public String visitFTERM(ExprParser.FTERMContext ctx) {
	  //System.out.println("term -> factor (MULDIVOP factor)*");
	  String fac = visit(ctx.factor(0));
	  int i = 1;
	  while (ctx.factor(i) != null) {
		  fac += " " + ctx.MULDIVOP(i-1).getText() + " " + visit(ctx.factor(i++));
	  }
	  return fac;
  }
  
  //term -> tone
  @Override public String visitTTERM(ExprParser.TTERMContext ctx) {
	  //System.out.println("term -> tone");
	  return visit(ctx.tone()); 
  }
  
//tone -> op=(SHARP|FLAT) atom
  @Override 
  public String visitSFATOMTONE(ExprParser.SFATOMTONEContext ctx) {
	  //System.out.println("tone -> op=(SHARP|FLAT) atom");
	  String sf = ctx.op.getText() + visit(ctx.atom());
	  return sf;
  }
  
  //tone -> atom
  @Override 
  public String visitATOMTONE(ExprParser.ATOMTONEContext ctx) {
	  //System.out.println("tone -> atom");
	  return visit(ctx.atom());
  }
  
  //factor -> op=('+'|'-')  factor
  public String visitPMFactor(ExprParser.PMFACTORContext ctx) {
	  //System.out.println("factor -> op=('+'|'-')  factor");
	  String pwr = ctx.op.getText() + " " + visit(ctx.factor());
	  return pwr;
  }
  
  //factor -> power
  public String visitPWFactor(ExprParser.PWFACTORContext ctx) {
	  //System.out.println("factor->power");
	  String pwr = visit(ctx.power());
	  return pwr;
  }
  
  //power -> atom_trailer ('**' factor)?
  public String visitPower(ExprParser.PowerContext ctx) {
	  //System.out.println("power -> atom_trailer ('**' factor)?");
	  String at = visit(ctx.atom_trailer());
	  return at;
  }
  
  //atom_trailer -> (THIS '.')? atom  (trailer)*;
  public String visitAtom_trailer(ExprParser.Atom_trailerContext ctx) {
	  //System.out.println("atom_trailer -> (THIS '.')? atom  (trailer)*");
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
	  //System.out.println("atom -> NAME");
	  String name = ctx.NAME().getText();
	  //System.out.println("NAME = " + name);
	  return name; 
  }
  
  //atom -> NUMBER
  @Override public String visitATOMNUM(ExprParser.ATOMNUMContext ctx) {
	  //System.out.println("atom->number");
	  String number = ctx.NUMBER().getText();
	  //System.out.println("NUMBER = " + number);
	  return number; 
  }
  
  //atom -> STRING+
  @Override public String visitATOMSTR(ExprParser.ATOMSTRContext ctx) {
	  //System.out.println("atom -> ATOMSTR");
	  String ret = ctx.STRING(0).getText();
	  int i = 1;
	  while (ctx.STRING(i) != null) {
		  ret += ctx.STRING(i).getText();
		  i++;
	  }
	  return ret;
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

		
