package sort;
import java.util.Arrays;

public class SelectSort implements SortIntf{
    @Override
    public  int[] sort(int[] srcArr) {

        int[] arr = Arrays.copyOf(srcArr, srcArr.length);
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            int min = i;
            for (int j = i; j < len; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                Exchange.exchange(arr, min, i);
            }
        }
        return arr;
    }
}
 