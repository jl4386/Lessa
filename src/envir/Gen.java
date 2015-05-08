package envir;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

public class Gen {
  
  //public static final String dirtyFileName = "dirty.txt";
  
  private static File temp;
  private static File exec;
  
  private static final String ImpPrefix ="from definition import";
  
  
  
  public static void initShell(){   
    temp = new File(Envir.tempFileName);
    exec = new File(Envir.exeFileName);
    //dirty = new File(dirtyFileName);
    if(temp.exists())
      temp.delete();
    
    if(exec.exists())
      exec.delete();
       
    
    try {
      temp.createNewFile();
      exec.createNewFile();
      
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
    
  }
  
  public static void genDefinition(String content, String name){
    try {      
      Writer w = new FileWriter(Envir.tempFileName, true);
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
      Writer w = new FileWriter(Envir.exeFileName, false);
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
  
  public static void refreshDirty(PythonInterpreter interpreter){
    /**
     * refresh dirty variables 
     */
    Iterator<Entry<String, Variable>> it = Envir.varTable.entrySet().iterator();
    while(it.hasNext()){
      Map.Entry<String, Variable> pair= it.next();
      
      if (pair.getValue().dirty){
        PyObject value = interpreter.get(pair.getKey());
        
        System.out.println(value);
        if(isInstance(value.toString())){
          System.out.println(value);
          System.out.println(getClassName(value.toString()));
          pair.getValue().value = getClassName(value.toString())+"()";
        }else{
          pair.getValue().value = value.toString();
        }
          
        
      }
      else if(pair.getValue().create){
        pair.getValue().create = false;
      }
    }
    
  }
  private static String getClassName(String test){
    String temp = test.substring("<definition.".length());
    
    return temp.split(" ")[0];
    
  }
  
  private static boolean isInstance(String test){
    return test.contains("instance");
  }
  
  public static void removeErrorVariables(){
    Iterator<Entry<String, Variable>> it = Envir.varTable.entrySet().iterator();
    while(it.hasNext()){
      Variable v = it.next().getValue();
      if (v.create){
        Envir.varTable.remove(v.name);
      }
    }
  }
  
  public static void writeVars(Writer w){
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
  
  
  public static void writeImps(Writer w){
    try {
      w.write("#Auto-generate imp_stmt support function and class\n");
      w.write("import imp\n");
      //w.write("music=imp.load_source('music', '"+Envir.dir+"music.py')\n" );
      String module = Envir.tempFileName.substring(0, Envir.tempFileName.length()-3);
      w.write(module+"=imp.load_source('"+module+"', '"+Envir.dir+Envir.tempFileName+"')\n" );  
      //w.write("from music import *");
      
      
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
  
  public static void main(String[] args){
////    Gen.initShell();
////    System.out.println(Gen.exec.canExecute());
//    Variable v = new Variable("i","13");
//    v.dirty = true;
//    Envir.varTable.put("i", v);
////    Gen.genDefinition("def A(){ print 1}\n", "A");    
////    Gen.genExecution("print(\"a = 1\");");
////    Gen.writeDirty();
//    Gen.refreshDirty();
//    System.out.println(Envir.varTable.get("i").value);
    System.out.println(System.getProperty("user.dir"));
    
  }
  
  
}
