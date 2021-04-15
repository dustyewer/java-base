package dynamicprogramming;

public class CoinChange {
    private  static  int change=29;
  public static void main(String[] args) {

      int[] f = new int[change];
      int[] Coin = {2,5,7};

      f[0]=0;
      for(int i=0;i<f.length;i++)
      {
        f[i]=Math.min(Math.min(f[i-2]+1,f[i-3]+1),f[i-5]+1);
      }





  }
}
