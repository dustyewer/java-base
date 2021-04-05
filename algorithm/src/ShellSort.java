import java.util.Arrays;

public class ShellSort implements SortIntf {
    @Override
    public int[] sort(int[] srcArr) {
        int len=srcArr.length;
        int[] arr = Arrays.copyOf(srcArr, len);
        int step=1;
        while(step<len/3){
            step=step*3+1;
        }

        do {
            for (int i = step; i <len ; i++) {
                int t=arr[i];
                int j=i-step;
                while (j >= 0 && arr[j] > t) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
//                if ((j+step)!=i)
                arr[j + step] = t;
            }

        }while((step/=3)>0);
        return arr;
    }
}
