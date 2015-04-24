package test;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.python.util.PythonInterpreter;



public class Test {

  private static Scanner sc;

  public static void main(String[] args) {
    // TODO Auto-generated method stub
   
//    sc = new Scanner(System.in);
//    String input = null;
//    Pattern pre = Pattern.compile("\\{");
//    Pattern pos = Pattern.compile("\\}");
//    Matcher prematcher = null;
//    Matcher posmatcher;
//    StringBuffer strseen = new StringBuffer();
//    int count = 0;//count the number of parenthesis
//    while (!(input = sc.nextLine()).equals("exit")){
//      strseen.append(input+"\n");
//      
//      if(input.endsWith(";")&&count==0){      
//        System.out.println(strseen.toString());
//        strseen.delete(0, strseen.length());
//        continue;
//      }
//
//      
//      prematcher = pre.matcher(input);
//      posmatcher = pos.matcher(input);
//      while(prematcher.find())
//        count++;
//      while(posmatcher.find())
//        count--;
//      
//      if (input.endsWith("}")&&count==0){
//        System.out.println(strseen.toString());
//        strseen.delete(0, strseen.length());
//        continue;
//      }
//      
//       
//    }
    
    /*
     * java execute python script
     * 
     */ 
    PythonInterpreter pi = new PythonInterpreter();
    try {
       
      InputStream filepy = new FileInputStream("/Users/apple/plt/proj/Lessa/test.py");
      pi.execfile(filepy);
      System.out.println(pi.get("i"));
      //pi.exec("This is a test\n");
      filepy.close();
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } 
    
    
    
    
  }

}
