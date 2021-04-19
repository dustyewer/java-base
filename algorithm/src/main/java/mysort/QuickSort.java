package mysort;

import java.util.Arrays;

public class QuickSort implements Sort {
  @Override
  public int[] sort(int[] arr) {
    int[] src = Arrays.copyOf(arr, arr.length);
    quickSort(src, 0, src.length - 1);
    return src;
  }

  private void quickSort(int[] src, int left, int right) {
    if (left >= right) {
      return;
    }
    int p = findp(src, left, right);
    quickSort(src, left, p - 1);
    quickSort(src, p + 1, right);
  }

  private int findp(int[] src, int left, int right) {
    int t = src[left];
    while (left < right) {
      while (src[right] >= t && left < right) {
        right--;
      }
      exchange(src, left, right);
      while (left < right && src[left] <= t) {
        left++;
      }
      exchange(src, left, right);
    }
    src[left] = t;
    return left;
  }
}
