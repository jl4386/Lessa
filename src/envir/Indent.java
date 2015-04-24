package envir;


public class Indent{
  //private Writer pw;
  private static StringBuffer indent = new StringBuffer();
  
//  public PyWriter(String filename){
//    try {
//      pw = new FileWriter(filename, true);
//    } catch (IOException e) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    }
//  }
//  protected void finalize(){
//    try {
//      pw.close();
//    } catch (IOException e) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    }
//  }
  public static String getIndent(){
    return(indent.toString());
  }
  
  public static void addIndent(){
    indent.append("  ");
  }
  public static void delIndent(){
    int len = indent.length();
    indent.delete(len-2, len);
  }
  
//  public void write(String content){
//    try {
//      pw.write(indent.toString());
//      pw.write(content);
//    } catch (IOException e) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    }
//    
//  }
}
