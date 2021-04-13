package sort;
import java.util.Arrays;

public class BubblingSort implements SortIntf{
    public  int[] sort(int[] srcArr) {

        int[] arr = Arrays.copyOf(srcArr, srcArr.length);
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    Exchange.exchange(arr, j, j + 1);
                }
            }
        }
        return arr;
    }
    
    
}