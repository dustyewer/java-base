package kaoshi;

import java.math.BigInteger;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Kaoshi1 {

    final String[] bin={"0","1","10","11","100","101","110","111","1000","1001"};
  public static void main(String[] args) {
    //
      String input;
      Kaoshi1 kaoshi1 = new Kaoshi1();
      Scanner scanner =new Scanner(System.in);
      while(scanner.hasNextLine()){
          input = scanner.nextLine();

          long begin=System.currentTimeMillis();
//          LocalDateTime begin= LocalDateTime.now();
          System.out.println(kaoshi1.fun2(input));
//          LocalDateTime end = LocalDateTime.now();
//            System.out.println(Duration.between(begin,end).toMillis());
            long end = System.currentTimeMillis();
      System.out.println(end-begin);

           begin=System.currentTimeMillis();
//           begin= LocalDateTime.now();
          System.out.println(kaoshi1.fun2(input));
//           end = LocalDateTime.now();
//          System.out.println(Duration.between(begin,end).toMillis());
           end = System.currentTimeMillis();
          System.out.println(end-begin);



           begin=System.currentTimeMillis();

//          begin= LocalDateTime.now();
          System.out.println(new BigInteger(input).toString(2));
//          end = LocalDateTime.now();
//          System.out.println(Duration.between(begin,end).toNanos());
           end = System.currentTimeMillis();
          System .out.println(end-begin);
      }

  }

  public  String fun(String input){

      String output=new String();
      while(input.length()>0){
          String curr= getBin((Integer.valueOf(input.substring(0,1))));
          if(output.length()==0) {
              output = curr;
          } else {
              output = binAdd(binPlusTen(output), curr);
          }
          input=input.substring(1,input.length());
      }

      return output.toString();
  }

    public  String fun2(String input){

        String output=new String();
        while(input.length()>0){
            String curr= getBin((Integer.valueOf(input.substring(0,1))));
            if(output.length()==0) {
                output = curr;
            } else {
                output = binAdd2(binPlusTen(output), curr);
            }
            input=input.substring(1,input.length());
        }

        return output.toString();
    }

  public  String binAdd(String a, String b){
      StringBuilder c= new StringBuilder();
      int ex=0;

      while(a.length()>0||b.length()>0){
          int count =0;
          if(a.length()>0){
            count+=Integer.valueOf(a.substring(a.length()-1,a.length()));
            a=a.substring(0,a.length()-1);
          }
          if(b.length()>0){
            count+=Integer.valueOf(b.substring(b.length()-1,b.length()));
            b=b.substring(0,b.length()-1);}
          count+=ex;

          if(count>1){
              ex=1;
          }else{
              ex=0;
          }
          c.insert(0,count>1?count-2:count);
      }
      if(ex==1){
          c.insert(0,1);
      }

      return c.toString();
  }

    public  String binAdd2(String a, String b){
        StringBuilder c= new StringBuilder();
        int ex=0;
        Stack<Character> stackA = new Stack<Character>();
        Stack<Character> stackB = new Stack<Character>();
        Stack<Integer> stackC = new Stack<Integer>();

        for (int i = 0; i < a.length(); i++) {
          stackA.push(a.charAt(i));
        }
        for (int i = 0; i < b.length(); i++) {
            stackB.push(b.charAt(i));
        }

        while(!stackA.isEmpty()||!stackB.isEmpty()){
            int count =0;
            if(!stackA.isEmpty()){
                count+=Integer.valueOf(stackA.pop()-'0');
            }
            if(!stackB.isEmpty()){
                count+=Integer.valueOf(stackB.pop()-'0');
            }
            count+=ex;

            if(count>1){
                ex=1;
            }else{
                ex=0;
            }
            stackC.push(count>1?count-2:count);
        }
        if(ex==1){
            stackC.push(1);
        }

        while(!stackC.isEmpty()){

            c=c.append(stackC.pop());
        }

        return c.toString();


    }

  public  String getBin(int i){
      if(i>=0&&i<=9){
          return bin[i];
      }
      return null;
  }

  public String binPlusTen(String a){
      return binAdd(a+"00",a)+"0";
  }

}
