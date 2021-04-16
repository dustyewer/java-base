package recursion;

import java.util.Scanner;

// 1 2 3 5 8 13 21 34 55 89
public class Fibonacci {
  public static void main(String[] args) {
    //
      Fibonacci fibonacci = new Fibonacci();
      Scanner scanner =new Scanner(System.in);
      int n=0;
      if(scanner.hasNextInt()){
          n=Integer.valueOf(scanner.next());
      }


    System.out.println(fibonacci.f(n));
  }

  public int f(int n){
    if (n == 1) {
      return 1;
      }else if(n==2){
        return 2;
    }else{
        return f(n-1)+f(n-2);
    }

  }
}
