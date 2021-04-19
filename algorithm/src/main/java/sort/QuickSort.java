package sort;

import java.util.Arrays;

public class QuickSort implements SortIntf {

  @Override
  public int[] sort(int[] srcArr) {
    int[] arr = Arrays.copyOf(srcArr, srcArr.length);

    return quickSort(arr, 0, arr.length - 1);
  }

  private int[] quickSort(int[] arr, int left, int right) {
    if (left < right) {
      int p = part(arr, left, right);
      quickSort(arr, left, p - 1);
      quickSort(arr, p + 1, right);
    }
    return arr;
  }

  private int part(int[] arr, int left, int right) {
    int pivot = left;
    int index = pivot + 1;
    for (int i = index; i <= right; i++) {
      if (arr[i] < arr[pivot]) {
        Exchange.exchange(arr, i, index);
        index++;
      }
    }
    Exchange.exchange(arr, pivot, index - 1);
    return index - 1;
  }
}
