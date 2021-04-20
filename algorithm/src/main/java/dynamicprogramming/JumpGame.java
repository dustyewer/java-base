package dynamicprogramming;

public class JumpGame {
  public static void main(String[] args) {
    //
    int[] a = {2, 2, 5, 1, 0, 4, 1, 2, 4, 2, 4, 1, 0, 1, 0, 0};

    boolean[] f = new boolean[a.length];

    f[0] = true;
    for (int i = 1; i < a.length; i++) {
      f[i] = false;
      for (int j = 0; j < i; j++) {
        if (f[j] && j + a[j] >= i) {
          f[i] = true;
          break;
        }
        //
      }
      //
    }
    System.out.println(f[a.length - 1]);
  }
}
