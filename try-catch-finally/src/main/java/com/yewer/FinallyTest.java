package com.yewer;

import java.util.Scanner;

public class FinallyTest {
  public static void main(String[] args) {
    //
    Scanner scanner = new Scanner(System.in);
    String line;
    while (scanner.hasNextLine()) {
      line = scanner.nextLine();

      System.out.println(tryFun(line));
    }
  }

  public static int tryFun(String line) {
    try {
      System.out.println("try:" + Integer.parseInt(line));
      return 1;
    }
    //      catch(Exception e){
    //          System.out.println("catch"+e);
    //          return 2;
    //      }
    finally {
      System.out.println("finally");
      // 不要在finall里面return
      return 3;
      // 不要在finally里面抛异常
      //          throw new RuntimeException();
    }
  }
}
