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
  public String getIndent(){
    return(indent.toString());
  }
  
  public void addIndent(){
    indent.append("\t");
  }
  public void delIndent(){
    int len = indent.length();
    indent.delete(len-"\t".length(), len);
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
  public static void main(String[] args){
    System.out.println("\t".length());
  }
}
