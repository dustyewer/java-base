package mysort;

import java.util.Arrays;

public class MergeSort implements Sort {
  @Override
  public int[] sort(int[] arr) {
    int[] src = Arrays.copyOf(arr, arr.length);
    if (src.length < 2) {
      return src;
    }

    int mid = src.length / 2;

    int[] left = Arrays.copyOfRange(arr, 0, mid);
    int[] right = Arrays.copyOfRange(arr, mid, arr.length);

    return merge(sort(left), sort(right));
  }

  public int[] merge(int[] left, int[] right) {
    int[] res = new int[left.length + right.length];
    int leftIndex = 0;
    int rightIndex = 0;
    int resIndex = 0;
    int leftLength = left.length;
    int rightLength = right.length;
    while (leftIndex < leftLength && rightIndex < rightLength) {
      if (left[leftIndex] < right[rightIndex]) {
        res[resIndex++] = left[leftIndex++];
      } else {
        res[resIndex++] = right[rightIndex++];
      }
    }
    while (leftIndex < leftLength) {
      res[resIndex++] = left[leftIndex++];
    }
    while (rightIndex < rightLength) {
      res[resIndex++] = right[rightIndex++];
    }
    return res;
  }
}
