package test;

import java.util.Scanner;

public class Test {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner sc = new Scanner(System.in);
    String input = null;
    while (!(input = sc.nextLine()).equals("exit")){
      System.out.println(input);
    }
  }

}
