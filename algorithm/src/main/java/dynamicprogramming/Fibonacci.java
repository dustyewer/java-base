package dynamicprogramming;

import java.util.Scanner;

// 1 2 3 5 8 13 21 34 55 89
public class Fibonacci {
  public static void main(String[] args) {
    //
      Scanner scanner =new Scanner(System.in);
      int n=0;
      if(scanner.hasNextInt()){
          n=Integer.valueOf(scanner.next());
      }
      int[] f = new int [n];

        for (int i = 0; i <n; i++) {
            if (i==0) {
                f[i]=1;
            }else if(i==1){
                f[i]=2;
            } else {
                f[i] = f[i - 1] + f[i - 2];
            }
        }
        System.out.println(f[n-1]);

    //
    int sum=0;
    for(int i=0;i<n;i++){
        sum+=f[i];
    }
    System.out.println(sum);
  }
}
