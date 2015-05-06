package envir;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

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
  
  public static void refreshDirty(){
    /**
     * To be finished
     */
    
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
