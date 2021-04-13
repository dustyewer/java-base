
package sort;
import java.util.Arrays;

public class HeapSort implements SortIntf {
    @Override
    public int[] sort(int[] srcArr) {
        int[] arr = Arrays.copyOf(srcArr, srcArr.length);
        int len = arr.length;
        buildMaxHeap(arr, len);

        for(int i=len-1;i>0;i--){
            Exchange.exchange(arr,0,i);
            len--;
            heapify(arr,0,len);
        }
        return arr;
    }

    private void buildMaxHeap(int[] s,int len){
        for (int i = len/2; i >=0 ; i--) {
            heapify(s,i,len);
            
        }

    }

    private void heapify(int[] s, int i, int len) {
        int left = i*2+1;
        int right = i*2+2;
        int largest =i;
        if(left<len && s[left]>s[largest]){
            largest=left;
        }

        if (right<len && s[right]>s[largest]) {
            largest =right;
        }

        if(largest !=i ){
            Exchange.exchange(s,largest,i);
            heapify(s,largest,len);
        }
    }
}
