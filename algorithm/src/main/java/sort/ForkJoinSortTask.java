package sort;
import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class ForkJoinSortTask extends RecursiveTask<int []>{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int arr[];

    public ForkJoinSortTask(int[] arr) {
        this.arr = arr;
    }

    @Override
    protected int[] compute() {
        int len = arr.length;
        if(len>2){
            int mid= len/2;
            ForkJoinSortTask leftTask = new ForkJoinSortTask(Arrays.copyOf(arr,mid));
            leftTask.fork();
            ForkJoinSortTask rightTask = new ForkJoinSortTask(Arrays.copyOfRange(arr,mid,len));
            rightTask.fork();

            int[] left = leftTask.join();
            int[] right = rightTask.join();
            int[] result =  merge(left,right);
            return result;
        }else {
            if(len == 1 || arr[0] <= arr[1]) {
                return arr;
            } else {
                int targetp[] = new int[2];
                targetp[0] = arr[1];
                targetp[1] = arr[0];
                return targetp;
            }
        }
    }

    private int[] merge(int[] left, int[] right) {
        int leftLen = left.length;
        int rightLen = right.length;
        int resultLen = leftLen+rightLen;
        int[] result = new int[resultLen];
        for (int i = 0, leftIndex=0, rightIndex = 0;i <resultLen ; i++) {

            int leftValue = leftIndex>=leftLen?Integer.MAX_VALUE:left[leftIndex];
            int rightValue = rightIndex>=rightLen?Integer.MAX_VALUE:right[rightIndex];
            if (leftValue<rightValue){
                leftIndex++;
                result[i]=leftValue;
            }
            else{
                rightIndex++;
                result[i]=rightValue;
            }
        }
        return  result;
    }
}
