package envir;

public class SenmanticError {
  public String type;
  public String codeNO;
  
  public SenmanticError(String content, String no){
    this.type = content;
    this.codeNO = no;
  }
}
