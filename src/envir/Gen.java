package envir;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Gen {
  private static final String tempFileName = "definition.py";
  private static final String exeFileName = "exec.py";
  private static final String dirtyFileName = "dirty.txt";
  
  private static File temp;
  private static File exec;
  private static File dirty;
  
  private static final String ImpPrefix ="from definition import";
  
  
  
  public static void initShell(){   
    temp = new File(tempFileName);
    exec = new File(exeFileName);
    dirty = new File(dirtyFileName);
    if(temp.exists())
      temp.delete();
    
    if(exec.exists())
      exec.delete();
       
    if(dirty.exists())
      dirty.delete();
    
    try {
      temp.createNewFile();
      exec.createNewFile();
      dirty.createNewFile();
      
      temp.setExecutable(true);
      exec.setExecutable(true);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  public static void closeShell(){
    if(temp.exists())
      temp.delete();
    if(exec.exists())
      exec.delete();
    if(dirty.exists())
      dirty.delete();
    
  }
  
  public static void genDefinition(String content, String name){
    try {      
      Writer w = new FileWriter(tempFileName, true);
      w.write(content);
      w.close();
      StringBuilder sb = new StringBuilder();
      sb.append(ImpPrefix).append(" ");
      sb.append(name).append("\n");
      
      Envir.defTable.put(name, new ImpStmt(sb.toString()));
      
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }  
  }
  
  public static void genExecution(String content){
    try {
      Writer w = new FileWriter(exeFileName, false);
      StringBuilder sb;
      
      // import other function or class
      for (ImpStmt def : Envir.defTable.values()){
        //System.out.println(def.stmt);
        w.write(def.stmt);     
      }
      
      // current version variables 
      for (Variable var : Envir.varTable.values()){
        sb = new StringBuilder();
        sb.append(var.name).append(" = ").append(var.value).append("\n");
        w.write(sb.toString());
      }
      // execution file content
      
      w.write(content+"\n\n");
      
      
      
      
      
      
      w.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  public static void refreshDirty(){
    try {
      BufferedReader r = new BufferedReader(new FileReader(dirtyFileName));
      String line;
      while((line=r.readLine())!=null){
        String[] pairs = line.split("=");
        if(Envir.varTable.containsKey(pairs[0])){
          Variable v= Envir.varTable.get(pairs[0]);
          v.dirty=false;
          v.value = pairs[1];
          Envir.varTable.put(pairs[0],v);
        }
      }
      r.close();
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }
  
  public static void writeDirty(){
    try {
      Writer w = new FileWriter(exeFileName, true);
      StringBuilder sb = new StringBuilder();
      sb.append("dirtyfile = open (").append("'");
      sb.append(dirtyFileName).append("', 'w') \n");
      w.write(sb.toString());
      
      String prefix = "dirtyfile.write(";
      String postfix = ")\n";
      for(Variable var : Envir.varTable.values()){
        if(var.dirty){
          sb = new StringBuilder(prefix);
          sb.append("'").append(var.name).append("=' + str(");
          sb.append(var.name).append(")").append(postfix);
          //System.out.println(sb);      
          w.write(sb.toString());
        }
      }    
      w.write("dirtyfile.close()");
      w.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } 
    }
  
  public static void main(String[] args){
//    Gen.initShell();
//    System.out.println(Gen.exec.canExecute());
    Variable v = new Variable("i","13");
    v.dirty = true;
    Envir.varTable.put("i", v);
//    Gen.genDefinition("def A(){ print 1}\n", "A");    
//    Gen.genExecution("print(\"a = 1\");");
//    Gen.writeDirty();
    Gen.refreshDirty();
    System.out.println(Envir.varTable.get("i").value);
    
    
  }
  
  
}
