package mysort;

import java.util.Arrays;

public class BubbleSort implements Sort {
  @Override
  public int[] sort(int[] arr) {
    int[] src = Arrays.copyOf(arr, arr.length);

    for (int i = 0; i < src.length; i++) {
      for (int j = 0; j < src.length - 1; j++) {
        //
        if (src[j] > src[j + 1]) {
          exchange(src, j, j + 1);
        }
      }
      //
    }
    return src;
  }
}
