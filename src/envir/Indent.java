package envir;


public class Indent{
  //private Writer pw;
  private StringBuffer indent ;
  

  public Indent(){
    indent= new StringBuffer("");
  }
  
  public String getIndent(){
    return(indent.toString());
  }
  
  public void addIndent(){
    indent.append("  ");
  }
  public void delIndent(){
    int len = indent.length();
    indent.delete(len-2, len);
  }
  
  public static void main(String[] args){
    Indent i = new Indent();

    System.out.println(i.getIndent()+"aa");
  }
  
}
