package lessa;


import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;





//import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.python.core.PyException;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

import envir.Envir;
import envir.Gen;
import envir.LessaError;
import envir.LessaErrorDic;
import envir.Variable;


public class Main {
  private static Scanner sc;
  private static PythonInterpreter interpreter;
  
  
  
  private static void parse(String s){
    InputStream stream = new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8));
    ANTLRInputStream input;
    //parse the statement
    try {
      input = new ANTLRInputStream(stream);
      ExprLexer lexer = new ExprLexer(input);
      lexer.removeErrorListeners();
      lexer.addErrorListener(DescriptiveErrorListener.INSTANCE);
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      ExprParser parser = new ExprParser(tokens);
      parser.removeErrorListeners();
      parser.addErrorListener(DescriptiveErrorListener.INSTANCE);
      ParseTree tree = parser.prog(); // parse

      EvalVisitor eval = new EvalVisitor();
      eval.visit(tree);
      
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    
  }
  
 
  
  private static void exec() throws InterruptedException{
  //run the statement
    interpreter = new PythonInterpreter();
    try {
       
      InputStream filepy = new FileInputStream(Envir.dir+Envir.exeFileName);
      
      
      interpreter.execfile(filepy);
            
      Iterator<Entry<String, Variable>> it = Envir.varTable.entrySet().iterator();
      while(it.hasNext()){
        Map.Entry<String, Variable> pair= it.next();
        if (pair.getValue().dirty){
          PyObject value = interpreter.get(pair.getKey());
          pair.getValue().value = value.toString();
        } 
      }
      
      filepy.close();
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }catch(PyException se){
      //se.printStackTrace();
      
      //TODO
      System.out.println(se.type);
      LessaError le = LessaErrorDic.Exceptions.get(se.type);
      StringBuffer sb = new StringBuffer("Error Number:");
      sb.append(" ").append(le.codeNO).append("  Type:").append(le.type);
      System.out.println(sb);
      System.out.println("Description: "+se.value);
      System.out.println(se.traceback.dumpStack());
      
      //remove error variables
      removeVariables();
      
    } 
  }
  
  private static void removeVariables(){
    Iterator<Entry<String, Variable>> it = Envir.varTable.entrySet().iterator();
    while(it.hasNext()){
      Variable v = it.next().getValue();
      if (v.create){
        Envir.varTable.remove(v.name);
      }
    }
  }
  
  
  public static void main(String[] args) throws Exception {
	sc = new Scanner(System.in);
    
    //initialization
    Gen.initShell();
    String input = null;
    Pattern pre = Pattern.compile("\\{");
    Pattern pos = Pattern.compile("\\}");
    Matcher prematcher;
    Matcher posmatcher;
    
    StringBuffer strseen = new StringBuffer();
    int count = 0;  //count the number of parenthesis
    
    
    System.out.println("Welcome to Lessa world!");
    System.out.println("Lessa 1.0");
    System.out.println("-------------------------------");
    while (!(input = sc.nextLine()).equals("exit()")){
      strseen.append(input+"\n");
      
      if(input.endsWith(";")&&count==0){      
        //System.out.println(strseen.toString());
        
        parse(strseen.toString());
        exec();
        
        
        strseen.delete(0, strseen.length());
        continue;
      }

      
      prematcher = pre.matcher(input);
      posmatcher = pos.matcher(input);
      
      while(prematcher.find())
        count++;
      while(posmatcher.find())
        count--;
      
      if (input.endsWith("}")&&count==0){
        //System.out.println(strseen.toString());
        
        parse(strseen.toString());
        exec();
        
        strseen.delete(0, strseen.length());
        continue;
      }
        
    }
    
    Gen.closeShell();
    
    
//    ExprLexer lexer = new ExprLexer(new ANTLRFileStream("?"));
//    ExprParser parser = new ExprParser(new CommonTokenStream(lexer));
//    //ParseTree tree = parser.parse();
//    EvalVisitor visitor = new EvalVisitor();
//    //visitor.visit(tree);
  }
}