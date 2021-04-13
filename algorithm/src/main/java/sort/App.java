package sort;

import java.util.Arrays;

import java.util.Random;


public class App {

//    static int[] srcArray = new int[] {3,6,1,9,4,7,11,1,2,5,16};
//    static int[] srcArray = new int[] {3,1};

    public static void main(String[] args) throws Exception {

        App app = new App();
        int[] srcArr = app.getArr(20);
            
//         SortIntf mySort = new BubblingSort();
//         SortIntf mySort = new SelectSort();
//         SortIntf mySort = new InsertSort();
//         SortIntf mySort = new MeregeSort();
//        SortIntf mySort = new QuickSort();
//        SortIntf mySort = new HeapSort();
    //    SortIntf mySort = new ShellSort();
        SortIntf mySort = new ForkJoinSort();


        int[] dstArr = mySort.sort(srcArr);
        sout(srcArr);
        sout(dstArr);
        System.out.println(app.check(srcArr, dstArr));

        Arrays.sort(srcArr);
        sout(srcArr);
        System.out.println(app.check(srcArr, dstArr));


    }

    private static void sout(int[] srcArr) {
        for (int i = 0; i < srcArr.length; i++) {
            System.out.print(srcArr[i] + " ");
        }
        System.out.println("");
    }

    int[] getArr(int len){
        int[] arr = new int[len];
        Random random = new Random();
        for (int i = 0; i <len ; i++) {
            arr[i]= random.nextInt(20);
        }
        return arr;
    }

    boolean check(int[] srcArr,int[] dstArr){
        if(srcArr.length!=dstArr.length){
            return false;
        }
        for (int i = 0; i < srcArr.length; i++) {
            if(srcArr[i]!=dstArr[i]){
                return false;
            }

        }
        return true;
    }
    
    
    
    
    

    
}
