package mysort;

import java.util.Arrays;

public class HeapSort implements Sort {
  @Override
  public int[] sort(int[] arr) {
    int[] src = Arrays.copyOf(arr, arr.length);

    heapify(src, src.length);
    for (int i = 1; i < src.length; i++) {
      //
      exchange(src, 0, src.length - i);
      heapify(src, src.length - i);
    }

    return src;
  }

  private void heapify(int[] src, int len) {
    for (int i = len / 2; i >= 0; i--) {
      //
      int left = i * 2 + 1;
      int right = i * 2 + 2;
      int large = i;

      if (left < len && src[left] > src[large]) {
        exchange(src, left, large);
      }
      if (right < len && src[right] > src[large]) {
        exchange(src, right, large);
      }
    }
  }
}
