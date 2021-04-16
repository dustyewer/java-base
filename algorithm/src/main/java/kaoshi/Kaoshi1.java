package kaoshi;

import java.math.BigInteger;
import java.util.Scanner;

public class Kaoshi1 {

    final String[] bin={"0","1","10","11","100","101","110","111","1000","1001"};
  public static void main(String[] args) {
    //
      String input;
      Kaoshi1 kaoshi1 = new Kaoshi1();
      Scanner scanner =new Scanner(System.in);
      while(scanner.hasNextLine()){
          input = scanner.nextLine();

          System.out.println(kaoshi1.fun(input));
          System.out.println(new BigInteger(input).toString(2));
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
