package mysort;

import java.util.Arrays;

public class SelectSort implements Sort {
  @Override
  public int[] sort(int[] arr) {
    int[] src = Arrays.copyOf(arr, arr.length);

    for (int i = 0; i < src.length - 1; i++) {
      int min = i;
      for (int j = i; j < src.length; j++) {
        if (src[min] > src[j]) {
          min = j;
        }
      }
      exchange(src, i, min);
    }
    return src;
  }
}
