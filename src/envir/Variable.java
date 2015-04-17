package envir;

public class Variable {
  public String name;
  public String value;
  public boolean dirty = false;
  
  public Variable(String name, String value){
    this.name = name;
    this.value = value;
    
  }
  
}
