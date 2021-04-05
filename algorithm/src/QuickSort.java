import java.util.Arrays;

public class QuickSort implements SortIntf {

    @Override
    public int[] sort(int[] srcArr) {
        int[] arr = Arrays.copyOf(srcArr, srcArr.length);

        return quickSort(arr,0,arr.length-1);
    }

    private int[] quickSort(int[] s, int left, int right) {
        if(left<right){
        int p = part(s,left,right);
        quickSort(s, left, p-1);
        quickSort(s, p+1, right);
        }
        return s;
    }

    private int part(int[] s, int left, int right) {
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (s[i] < s[pivot]) {
                Exchange.exchange(s, i, index);
                index++;
            }

        }
        Exchange.exchange(s,pivot,index-1);
        return index-1;


        
    }
    
}
