package mysort;

import java.util.Arrays;
import java.util.Random;

public interface Sort {
  public int[] sort(int[] arr);

  public default void exchange(int[] arr, int x, int y) {
    int t;
    t = arr[x];
    arr[x] = arr[y];
    arr[y] = t;
  }

  public default boolean check() {
    Random random = new Random();
    int len = random.nextInt(100);
    int[] arr = new int[len];
    for (int i = 0; i < len; i++) {
      arr[i] = random.nextInt(100);
    }
    int[] dst = sort(arr);
    Arrays.sort(arr);
    for (int i = 0; i < len; i++) {
      //
      if (dst[i] != arr[i]) {
        return false;
      }
    }
    return true;
  }

  public default boolean check(int num) {
    for (int i = 0; i < num; i++) {
      //
      if (!check()) {
        return false;
      }
    }
    return true;
  }
}
