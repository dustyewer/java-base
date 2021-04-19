package mysort;

public class App {

  public static void main(String[] args) {
    //
    App app = new App();
    int[] arr = {4, 5, 3, 8, -1, 9, 3, 6, 12, 1, 4, 0};
    app.sout(arr);
    Sort mySort = SimpleSortFactory.getSort("Quick");
    app.sout(mySort.sort(arr));
    System.out.println("my sort check result:" + mySort.check(1000));
  }

  public void sout(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      //
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
}
