package sort;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class ForkJoinSort implements SortIntf{

    @Override
    public int[] sort(int[] srcArr) {
        int[] arr = Arrays.copyOf(srcArr, srcArr.length);

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinSortTask forkJoinSortTask = new ForkJoinSortTask(arr);
        ForkJoinTask<int[]> taskResult = forkJoinPool.submit(forkJoinSortTask);
        try{
            arr=taskResult.get();
        }catch (InterruptedException| ExecutionException e){
            e.printStackTrace();
        }
        return arr;
    }
}
