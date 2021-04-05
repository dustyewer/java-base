import java.util.Arrays;

public class MeregeSort implements SortIntf {
    

    protected int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }
        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }
        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }
        return result;
    }

    @Override
    public int[] sort(int[] srcArr) {

        int[] arr = Arrays.copyOf(srcArr, srcArr.length);

        if (arr.length < 2) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        return merge2(sort(left), sort(right));
    }
    
    protected int[] merge2(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i=0;
        int l=0;
        int r=0;
        while (l < left.length && r < right.length) {
            if (left[l] <= right[r]) {
                result[i++] = left[l];
                l++;
            } else {
                result[i++] = right[r];
                r++;
            }
        }
        while (r < right.length) {
            result[i++] = right[r];
            r++;
        }
        while (l < left.length) {
            result[i++] = left[l];
            l++;
        }
        return result;
    }
}
