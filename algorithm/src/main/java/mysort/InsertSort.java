package mysort;

import java.util.Arrays;

public class InsertSort implements Sort {
  @Override
  public int[] sort(int[] arr) {
    int[] src = Arrays.copyOf(arr, arr.length);

    for (int i = 1; i < src.length; i++) {
      int t = src[i];
      int j = i;
      while (j > 0 && src[j - 1] > t) {
        src[j] = src[j - 1];
        j--;
      }
      src[j] = t;
    }
    return src;
  }
}
