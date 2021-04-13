package sort;

public class Exchange {
    

    public static void exchange(int[] l, int s, int d) {
        int t = l[d];
        l[d] = l[s];
        l[s] = t;
    }

}
