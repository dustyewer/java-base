package mysort;

import java.util.Arrays;

public class ShellSort implements Sort {
  @Override
  public int[] sort(int[] arr) {
    int[] src = Arrays.copyOf(arr, arr.length);
    int step = 1;
    while (step * 3 < src.length) {
      step = step * 3 + 1;
    }
    int len = src.length;
    do {
      for (int i = step; i < len; i++) {
        int t = src[i];
        int j = i;
        while (j >= step && t < src[j - step]) {
          src[j] = src[j - step];
          j = j - step;
        }
        src[j] = t;
      }

    } while ((step /= 3) > 0);

    return src;
  }
}
