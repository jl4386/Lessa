package lessa;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main {
  private static Scanner sc;
  
  
  private static void parseAndRun(String s){
    InputStream stream = new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8));
    ANTLRInputStream input;
    try {
      input = new ANTLRInputStream(stream);
      ExprLexer lexer = new ExprLexer(input);
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      ExprParser parser = new ExprParser(tokens);
      ParseTree tree = parser.prog(); // parse

      EvalVisitor eval = new EvalVisitor();
      eval.visit(tree);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }
  
  public static void main(String[] args) throws Exception {
      
    sc = new Scanner(System.in);
    
    String input = null;
    Pattern pre = Pattern.compile("\\{");
    Pattern pos = Pattern.compile("\\}");
    Matcher prematcher;
    Matcher posmatcher;
    
    StringBuffer strseen = new StringBuffer();
    int count = 0;//count the number of parenthesis
    
    
    while (!(input = sc.nextLine()).equals("exit")){
      strseen.append(input+"\n");
      
      if(input.endsWith(";")&&count==0){      
        //System.out.println(strseen.toString());
        
        parseAndRun(strseen.toString());
        
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
        
        parseAndRun(strseen.toString());
        
        strseen.delete(0, strseen.length());
        continue;
      }
        
    }
    
    
//    ExprLexer lexer = new ExprLexer(new ANTLRFileStream("?"));
//    ExprParser parser = new ExprParser(new CommonTokenStream(lexer));
//    //ParseTree tree = parser.parse();
//    EvalVisitor visitor = new EvalVisitor();
//    //visitor.visit(tree);
  }
}