package com.yewer.thread_lock_sync;

import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

public class Kaoshi2 {
  public static void main(String[] args) {
      Scanner scanner=new Scanner(System.in);
      String line;
      while(scanner.hasNextLine()){
          line=scanner.nextLine().trim();
          StringBuilder sb = new StringBuilder(line);
          Stack<String> stack = new Stack<>();
        for (int i = 0; i < line.length(); i++) {
            stack.push(line.substring(i,i+1));
        }
        int i=0;
        while(!stack.isEmpty()){
            int temp = Integer.valueOf(stack.pop());
            temp
            System.out.println(stack.pop());
            i++;
        }
      }
  }
}
