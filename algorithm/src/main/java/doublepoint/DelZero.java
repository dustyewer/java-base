package doublepoint;

import java.util.Arrays;

public class DelZero {

  public static void main(String[] args) {
    //
    int[] arr = {1, 0, 2, 0, 3, 5, 7, 0};
    DelZero delZero = new DelZero();
    System.out.println(delZero.fun(arr));
  }

  public int[] fun(int[] arr) {

    int[] src = Arrays.copyOf(arr, arr.length);

    int j = 0;
    for (int i = 0; i < src.length; i++) {
      //
      if (src[i] != 0) {
        if (i != j) {
          src[j] = src[i];
          src[i] = 0;
        }
        j++;
      }
    }

    return src;
  }
}
