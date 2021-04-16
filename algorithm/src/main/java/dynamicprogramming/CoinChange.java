package dynamicprogramming;

import java.util.Scanner;

public class CoinChange {

  public static void main(String[] args) {
      Scanner scanner =new Scanner(System.in);
      int n=0;
      if(scanner.hasNextInt()){
          n=Integer.valueOf(scanner.next());
      }


      int[] f = new int[n+1];
      int[] Coin = {2,5,7};

      f[0]=0;
      for(int i=1;i<=n;i++)
      {
          System.out.println("++++++++"+i+"++++++++");
          f[i]=Integer.MAX_VALUE;
          for(int j=0;j<Coin.length;j++)
          {
              if (i >= Coin[j] && f[i-Coin[j]]!=Integer.MAX_VALUE) {
                f[i] = Math.min(f[i - Coin[j]] + 1, f[i]);
//                System.out.println("use:"+Coin[j]);
//                if(f[i]!=Integer.MAX_VALUE){
//                     System.out.println(f[i]);
//                }
              }
          }

      }

    System.out.println(f[n]);
  }
}
