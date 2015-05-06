package lessa;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.io.*;

import envir.Envir;
import envir.Gen;
import envir.ImpStmt;
import envir.Indent;
import envir.Variable;


public class EvalVisitor extends ExprBaseVisitor<String> {
  Map<String, Integer> memory = new HashMap<String, Integer>();//我不知道这是啥！！！
  Indent indent = new Indent();
  boolean funcflag = false;
  boolean classflag = false;
  
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
  private void writeVars(Writer w){
    Iterator<Entry<String, Variable>> it = Envir.varTable.entrySet().iterator();
    try {
      w.write("#Auto-generate variables from variable tables\n");
    
    while(it.hasNext()){
      Map.Entry<String, Variable> pair= it.next();
     
        if(pair.getValue().create){
          pair.getValue().create=false;
        }else{
          w.write(pair.getKey());
          w.write("=");
          w.write(pair.getValue().value);
          w.write("\n");
        } 
      }
    w.write("\n");
    } catch (IOException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
  }
  
  private void writeImps(Writer w){
    try {
      w.write("#Auto-generate imp_stmt support function and class\n");
      w.write("import imp\n");
      String module = Envir.tempFileName.substring(0, Envir.tempFileName.length()-3);
      w.write(module+"=imp.load_source('"+module+"', '"+Envir.dir+Envir.tempFileName+"')\n" );  
    
    Iterator<Entry<String, ImpStmt>> it = Envir.defTable.entrySet().iterator();
    
    while(it.hasNext()){
      Map.Entry<String, ImpStmt> pair = it.next();
      
        
        w.write(pair.getValue().stmt);
        w.write("\n");
      
    }
    w.write("\n");
    } catch (IOException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
  }
  
  
  //single_input -> (stmt)* 
  @Override public String visitSingle_input(ExprParser.Single_inputContext ctx) {
	  System.out.println("single_input -> (stmt)* ");
	  int i = 0;
	  
	  
	  String input = "";
	  while(ctx.stmt(i) != null) {
		  input += visit(ctx.stmt(i++)) + "\n";
		  i++;
	  }
	  
	  try {
	    Writer exWriter = new FileWriter(Envir.exeFileName, false);
	    
	    if(funcflag || classflag){
          Writer w = new FileWriter(Envir.tempFileName, true);
          w.write(input);
          w.close();
          
        }else{
          
          writeImps(exWriter);
          writeVars(exWriter);
          exWriter.write(input);
          exWriter.write("\n");
          exWriter.close();
          System.out.println("final written single_input:");
          System.out.println(input);
        }
	    } catch (IOException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	  return input;
  }
  
  //stmt -> simple_stmt 
  @Override public String visitSIMPLESTMT(ExprParser.SIMPLESTMTContext ctx) { 
	  System.out.println("stmt -> simple_stmt ");
	  return visit(ctx.simple_stmt());
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
  
  //simple_stmt -> small_stmt (';' small_stmt)* ';' 
  @Override public String visitSimple_stmt(ExprParser.Simple_stmtContext ctx) {
	  System.out.println("simple_stmt -> small_stmt (';' small_stmt)* ';' ");
	  String ret = visit(ctx.small_stmt(0)) + "\n";
	  int i = 1;
	  while(ctx.small_stmt(i) != null) {
		  ret += visit(ctx.small_stmt(i)) + "\n";
		  i++;
	  }
	  return ret;
  }
  
  //small_stmt -> (del_stmt | import_stmt) 
  @Override public String visitSmall_stmt(ExprParser.Small_stmtContext ctx) { 
	  System.out.println("small_stmt -> (del_stmt | import_stmt)");
	  if (ctx.del_stmt() != null) {
		  return visit(ctx.del_stmt());
	  } else if (ctx.import_stmt() != null) {
		  return visit(ctx.import_stmt());
	  }
	  return visitChildren(ctx);
  }
  
  //del_stmt -> DEL expr_list 
  @Override public String visitDel_stmt(ExprParser.Del_stmtContext ctx) {
	  System.out.println("del_stmt -> DEL expr_: ");
	  String ret = ctx.DEL().getText() +" " +  visit(ctx.expr_list());
	  return ret;
  }
  
  //import_stmt -> import_name
  @Override public String visitIMNAMESTMT(ExprParser.IMNAMESTMTContext ctx) {
	  System.out.println("import_stmt -> import_name");
	  String ret = visit(ctx.import_name());
	  return ret;
  }
  
  //import_stmt -> import_from
  @Override public String visitIMFROMSTMT(ExprParser.IMFROMSTMTContext ctx) { 
	  System.out.println("import_stmt -> import_from");
	  String ret = visit(ctx.import_from());
	  return ret;
  }
  
  //import_from -> (FROM ('.'* dotted_name | '.'+) IMPORT ('*' | '(' import_as_names ')' | import_as_names) )
  @Override public String visitImport_from(ExprParser.Import_fromContext ctx) { 
	  System.out.println("import_from -> (FROM ('.'* dotted_name | '.'+) IMPORT ('*' | '(' import_as_names ')' | import_as_names) )");
	  String ret = "from" + " ";
	  
	  String text = ctx.getText();
	  int index = text.indexOf("import");
	  String prefix = text.substring(0, index);
	  String postfix = text.substring(index);
	  String midStr = prefix.replace("from", "");
	  String lastStr = postfix.replace("import", "");
	  
	  
	  if (ctx.dotted_name() != null) {
		  ret += visit(ctx.dotted_name());
	  } else {
		  ret += midStr;
	  }
	  
	  ret += " " + "import" + " ";
	  
	  if(ctx.import_as_names() != null) {
		  ret += visit(ctx.import_as_names());
	  } else {
		  ret += lastStr;
	  }
	  
	  
	  System.out.println("import_from -> (FROM ('.'* dotted_name | '.'+) IMPORT ('*' | '(' import_as_names ')' | import_as_names) ) return:");
	  System.out.println(ret);
	  return ret;
  }
  
  //import_as_names -> import_as_name (',' import_as_name)* ;
  @Override public String visitImport_as_names(ExprParser.Import_as_namesContext ctx) { 
	  System.out.println("import_as_names -> import_as_name (',' import_as_name)*");
	  String ret = visit(ctx.import_as_name(0));
	  int i = 1;
	  while (ctx.import_as_name(i) != null) {
		  ret += "," + visit(ctx.import_as_name(i));
		  i++;
	  }
	  System.out.println("import_as_names -> import_as_name (',' import_as_name)* return:" + ret);
	  return ret;
  }
  
  //import_as_name -> NAME ('as' NAME)? ;
  @Override public String visitImport_as_name(ExprParser.Import_as_nameContext ctx) {
	  System.out.println("import_as_name -> NAME ('as' NAME)?");
	  String ret = ctx.NAME(0).getText();
	  int i = 1;
	  if (ctx.NAME(i) != null) {
		  ret += " as " + ctx.NAME(i).getText();
	  }
	  System.out.println("import_as_name -> NAME ('as' NAME)? return:" + ret);
	  return ret;
  }
  
 
  //import_name -> IMPORT dotted_as_names 
  @Override public String visitImport_name(ExprParser.Import_nameContext ctx) { 
	  System.out.println("import_name -> IMPORT dotted_as_names");
	  String ret = ctx.IMPORT().getText() + " " + visit(ctx.dotted_as_names());
	  System.out.println("import_name -> IMPORT dotted_as_names return:" + ret);
	  return ret;
  }
  //dotted_as_names -> dotted_as_name (',' dotted_as_name)* 
  @Override public String visitDotted_as_names(ExprParser.Dotted_as_namesContext ctx) { 
	  System.out.println("dotted_as_names -> dotted_as_name (',' dotted_as_name)*");
	  String ret = visit(ctx.dotted_as_name(0));
	  int i = 1;
	  while (ctx.dotted_as_name(i) != null) {
		  ret += "," + visit(ctx.dotted_as_name(i));
		  i++;
	  }
	  System.out.println("dotted_as_names -> dotted_as_name (',' dotted_as_name)* return:" + ret);
	  return ret;
  }
  
  //dotted_as_name -> dotted_name ('as' NAME)? 
  @Override public String visitDotted_as_name(ExprParser.Dotted_as_nameContext ctx) { 
	  System.out.println("dotted_as_name -> dotted_name ('as' NAME)?");
	  String ret = visit(ctx.dotted_name());
	  if (ctx.NAME() != null) {
		  ret += "as" + " " +  ctx.NAME().getText(); 
	  }
	  System.out.println("dotted_as_name -> dotted_name ('as' NAME)? return:" + ret);
	  return ret;
  }
  
  //dotted_name -> NAME ('.' NAME)* 
  @Override public String visitDotted_name(ExprParser.Dotted_nameContext ctx) { 
	  System.out.println("dotted_name -> NAME ('.' NAME)*");
	  String ret = ctx.NAME(0).getText();
	  int i = 1;
	  while (ctx.NAME(i) != null) {
		  ret += "." + ctx.NAME(i).getText();
		  i++;
	  }
	  System.out.println("dotted_name -> NAME ('.' NAME)* return:" + ret);
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
	  String ret = ctx.RETURN().getText()+" ";
	  if (ctx.test_list() != null) {
		  ret += visit(ctx.test_list());
	  }
	  return ret;
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
	  String expr = visit(ctx.expr(0));
	  String value = visit(ctx.expr(1));
	  StringBuffer ret =new StringBuffer();
	  ret.append(expr).append(" ").append(visit(ctx.assign_operators()));
	  ret.append(" ").append(value); 
	  if(!(classflag || funcflag)){
	    if(Envir.varTable.containsKey(expr)){
	      Envir.varTable.get(expr).dirty=true;
	    }else{
	      Variable v = new Variable(expr,value);
	      Envir.varTable.put(expr, v);
	      //v.dirty=true;
	    }
	  }
        
	  
	  System.out.println("assign_stmt return:" + ret);
	  return ret.toString();
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
  
  //funcdef_stmt
  @Override
  public String visitFuncdef(ExprParser.FuncdefContext ctx) {
    funcflag = true;
    String name =ctx.NAME().getText();
    
    // generate import stmt if it is not class function
    if(!classflag){
      ImpStmt is = new ImpStmt("from "
          + Envir.tempFileName.substring(0, Envir.tempFileName.length()-3)
          + " import "+name);
      Envir.defTable.put(name, is);
    }
      
    StringBuffer func = new StringBuffer();
    func.append(indent.getIndent());
    func.append("def").append(" ").append(name);
    func.append(visit(ctx.parameters())).append(":\n");
     
    indent.addIndent();
    String rt = func.toString()+visit(ctx.compound_stmt());
    indent.delIndent();
    return rt;
  }
  
  //classdef_stmt
  //TODO
  @Override 
  public String visitClassdef(ExprParser.ClassdefContext ctx) { 
    classflag = true;
    StringBuffer cls = new StringBuffer();
    String name = ctx.NAME().getText();
    
    // generate import from class definition
    ImpStmt is = new ImpStmt("from "
        + Envir.tempFileName.substring(0, Envir.tempFileName.length()-3)
        + " import " + name);
    Envir.defTable.put(name, is);
    
    cls.append("class").append(" ").append(name).append("(");
    if (ctx.test_list()!=null)
      cls.append(visit(ctx.test_list()));
    cls.append(")").append(":\n");
    indent.addIndent();
    String rt = cls.toString()+visit(ctx.compound_stmt());
    indent.delIndent();
    return rt; 
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
	  ret += visit(ctx.arith_expr(0));
	  int i = 1;
	  while(ctx.arith_expr(i) != null) {
		  ret += " " + visit(ctx.comp_op(i-1)) + " ";
		  ret += visit(ctx.arith_expr(i));
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
	  System.out.println("expr_list -> expr (',' expr)*");
	  String expression = visit(ctx.expr(0));
	  int i = 1;
	  while (ctx.expr(i) != null) {
		  expression += " ," + visit(ctx.expr(i++));
		  i++;
	  }
	  return expression;
  }
  
  //expr -> arith_expr
  @Override
  public String visitExpr(ExprParser.ExprContext ctx) {
	  //String expression = indent.getIndent() + visit(ctx.arith_expr()); // Why indent here ? 
	  System.out.println("expr -> arith_expr");
	  String expression = visit(ctx.arith_expr());
	  return expression;
  }
  
  //arith_expr -> term (op=('+'|'-') term)* ;
  @Override 
  public String visitArith_expr(ExprParser.Arith_exprContext ctx) {
	System.out.println("arith_expr -> term (op=('+'|'-') term)*");
    String arithstring = visit(ctx.term(0));
    int i = 1;
    while (ctx.term(i) != null) {
    	arithstring += " " + ctx.ADDMINOP(i-1).getText() + " " + visit(ctx.term(i++)); 
    	i++;
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
	  System.out.println("term -> factor (MULDIVOP factor)*");
	  String fac = visit(ctx.factor(0));
	  int i = 1;
	  while (ctx.factor(i) != null) {
		  fac += " " + ctx.MULDIVOP(i-1).getText() + " " + visit(ctx.factor(i++));
		  i++;
	  }
	  return fac;
  }
  
  //term -> tone
  @Override public String visitTTERM(ExprParser.TTERMContext ctx) {
	  System.out.println("term -> tone");
	  return visit(ctx.tone()); 
  }
  
//tone -> op=(SHARP|FLAT) atom
  @Override 
  public String visitSFATOMTONE(ExprParser.SFATOMTONEContext ctx) {
	  System.out.println("tone -> op=(SHARP|FLAT) atom");
	  String sf = ctx.op.getText() + visit(ctx.atom());
	  return sf;
  }
  
  //tone -> atom
  @Override 
  public String visitATOMTONE(ExprParser.ATOMTONEContext ctx) {
	  System.out.println("tone -> atom");
	  return visit(ctx.atom());
  }
  
  //factor -> op=('+'|'-')  factor
  public String visitPMFactor(ExprParser.PMFACTORContext ctx) {
	  System.out.println("factor -> op=('+'|'-')  factor");
	  String pwr = ctx.op.getText() + " " + visit(ctx.factor());
	  return pwr;
  }
  
  //factor -> power
  public String visitPWFactor(ExprParser.PWFACTORContext ctx) {
	  System.out.println("factor->power");
	  String pwr = visit(ctx.power());
	  return pwr;
  }
  
  //power -> atom_trailer ('**' factor)?
  public String visitPower(ExprParser.PowerContext ctx) {
	  System.out.println("power -> atom_trailer ('**' factor)?");
	  String at = visit(ctx.atom_trailer());
	  return at;
  }
  
  //atom_trailer -> (THIS '.')? atom  (trailer)*;
  public String visitAtom_trailer(ExprParser.Atom_trailerContext ctx) {
	  System.out.println("atom_trailer -> (THIS '.')? atom  (trailer)*");
	  String at = "";
	  if (ctx.THIS() != null) {
		  at = "self.";
	  }
	  at += visit(ctx.atom());
	  int i = 0;
	  while (ctx.trailer(i) != null) {
		  at += visit(ctx.trailer(i++));
		  i++;
	  }
	  return at;
  }
  
  //atom -> NAME
  @Override public String visitATOMNAME(ExprParser.ATOMNAMEContext ctx) {
	  System.out.println("atom -> NAME");
	  String name = ctx.NAME().getText();
	  //System.out.println("NAME = " + name);
	  return name; 
  }
  
  //atom -> NUMBER
  @Override public String visitATOMNUM(ExprParser.ATOMNUMContext ctx) {
	  System.out.println("atom->number");
	  String number = ctx.NUMBER().getText();
	  //System.out.println("NUMBER = " + number);
	  return number; 
  }
  
  //atom -> STRING+
  @Override public String visitATOMSTR(ExprParser.ATOMSTRContext ctx) {
	  System.out.println("atom -> ATOMSTR");
	  String ret = ctx.STRING(0).getText();
	  int i = 1;
	  while (ctx.STRING(i) != null) {
		  ret += ctx.STRING(i).getText();
		  i++;
	  }
	  return ret;
  }
  
  //atom -> NONE
  @Override public String visitATOMNONE(ExprParser.ATOMNONEContext ctx) {
	  return ctx.NONE().getText();
  }
  
  //atom -> TRUE
  @Override public String visitATOMTR(ExprParser.ATOMTRContext ctx) { 
	  return ctx.TRUE().getText();
  }
  
  //atom -> FALSE
  @Override public String visitATOMFAL(ExprParser.ATOMFALContext ctx) {
	  return ctx.FALSE().getText();
  }
  
  //atom -> '(' (listmaker_test)? ')' 
  @Override public String visitATOMLIST(ExprParser.ATOMLISTContext ctx) {
	  System.out.println("'(' (listmaker_test)? ')' ");
	  String ret = "[" + visit(ctx.listmaker_test()) + "]";
	  return ret;
  }
 
  
  //trailer ->'(' arglist? ')'
  @Override public String visitTLRARG(ExprParser.TLRARGContext ctx) { 
	  System.out.println("trailer ->'(' arglist? ')'");
	  StringBuffer ret = new StringBuffer();
	  ret.append("(");
	  if(ctx.arglist()!=null){
	    ret.append(visit(ctx.arglist()));
	  }
	  ret.append( ")");
	  return ret.toString();
  }
  
  //trailer -> '[' subscriptlist ']'
  @Override public String visitTLRSUBLIST(ExprParser.TLRSUBLISTContext ctx) {
	  System.out.println("trailer -> '[' subscriptlist ']'");
	  String ret = "[" + visit(ctx.subscriptlist()) + "]";
	  System.out.println("trailer -> '[' subscriptlist ']' return:" + ret);
	  return ret;
  }
  
  //trailer -> '.' NAME
  @Override public String visitTLRNAME(ExprParser.TLRNAMEContext ctx) { 
	  System.out.println("trailer -> '.' NAME");
	  return visitChildren(ctx);
  }
  
  //subscriptlist -> subscript ( ',' subscript )* 
  @Override public String visitSubscriptlist(ExprParser.SubscriptlistContext ctx) { 
	  System.out.println("subscriptlist -> subscript ( ',' subscript )* ");
	  String ret = visit(ctx.subscript(0));
	  int i = 1;
	  while (ctx.subscript(i) != null) {
		  ret += "," + visit(ctx.subscript(i));
		  i++;
	  }
	  System.out.println("subscriptlist -> subscript ( ',' subscript )* return:" + ret);
	  return ret;
  }
  
  //subscript -> test  
  @Override public String visitSUBSCRT(ExprParser.SUBSCRTContext ctx) { 
	  System.out.println("subscript -> test");
	  String ret =  visit(ctx.test());
	  System.out.println("subscript -> test return:" + ret);
	  return ret;
  }
  
  //subscript -> test? ':' test? sliceop?
  @Override public String visitSUBSCRTT(ExprParser.SUBSCRTTContext ctx) { 
	  System.out.println("subscript -> test? ':' test? sliceop?");
	  String ret = "";
	  if (ctx.test(0) != null) {
		  ret = visit(ctx.test(0));
	  }
	  ret += ":";
	  if (ctx.test(1) != null) {
		  ret += visit(ctx.test(1));
	  }
	  if (ctx.sliceop() != null) {
		  ret += visit(ctx.sliceop());
	  }
	  System.out.println("subscript -> test? ':' test? sliceop? return:" + ret);
	  return ret;
  }
  
  //sliceop -> ':' (test)? 
  @Override public String visitSliceop(ExprParser.SliceopContext ctx) { 
	  System.out.println("sliceop -> ':' (test)? ");
	  String ret = ":";
	  if (ctx.test() != null) {
		  ret = visit(ctx.test());
	  }
	  System.out.println("sliceop -> ':' (test)? return:" + ret);
	  return ret;
  }
  
  //listmaker -> test ( list_for | (',' test)* )
  @Override public String visitListmaker_test(ExprParser.Listmaker_testContext ctx) {
	  System.out.println("test ( list_for | (',' test)* )" );
	  String ret = visit(ctx.test(0));
	  int i = 1;
	  while (ctx.test(i) != null) {
		  ret += ", ";
		  ret += visit(ctx.test(i));
		  i++;
	  }
	  return ret;
  }
  //parameters -> '(' (varargslist)? ')'
  @Override public String visitParameters(ExprParser.ParametersContext ctx) { 
    StringBuffer sb = new StringBuffer();
    sb.append("(");
    if (classflag)
      sb.append("self,");
    String rt = sb.toString();
    if (ctx.varargslist()!=null)
      rt += visit(ctx.varargslist());
    rt += ")";
    return rt; 
  }
  
  //varagslist -> (fpdef ('=' test)? ',')* ('*' NAME (',' '**' NAME)? | '**' NAME) 
  //             | fpdef ('=' test)? (',' fpdef ('=' test)?)* (',')? 
  @Override public String visitVarargslist(ExprParser.VarargslistContext ctx) {
     //String s=null;
     int i=0;
     StringBuffer sb = new StringBuffer();
     while(ctx.fpdef(i)!=null){
       sb.append(visit(ctx.fpdef(i)));
       if(ctx.test(i)!=null)
         sb.append("=").append(visit(ctx.test(i)));
       sb.append(", ");
       i++;
     }   
     return sb.toString();
  }
  
  @Override public String visitFPDEFNAME(ExprParser.FPDEFNAMEContext ctx) { 
    //System.out.println("TOKENN:"+ctx.getText());
    return ctx.getText(); 
  }
  
  @Override public String visitFPDEFLIST(ExprParser.FPDEFLISTContext ctx) { 
    //System.out.println("FPDLIST:"+ctx.getText());
    return ctx.getText();
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

		
