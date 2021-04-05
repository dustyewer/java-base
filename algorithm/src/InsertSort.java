import java.util.Arrays;

public class InsertSort implements SortIntf{
    public  int[] sort(int[] srcArr) {

        int[] arr = Arrays.copyOf(srcArr, srcArr.length);

        for (int i = 1; i < arr.length; i++) {
            int t = arr[i];
            int j = i;
            while (j > 0 && t < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
//            if (j != i) {
                arr[j] = t;
//            }
        }
        return arr;
    }

}
