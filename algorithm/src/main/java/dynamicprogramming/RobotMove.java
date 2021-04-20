package dynamicprogramming;

public class RobotMove {
  public static void main(String[] args) {

    int m = 5;
    int n = 4;
    int[][] f = new int[m][n];

    // 初始化，可以放到循环里面
    //    f[0][0] = 1;
    //
    //    for (int i = 0; i < n; i++) {
    //      f[0][i] = 1;
    //    }
    //    for (int i = 0; i < m; i++) {
    //      f[i][0] = 1;
    //    }

    // f[m-1][n-1]=f[m-1][n-2]+f[m-2][n-1]
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 || j == 0) {
          f[i][j] = 1;
        } else {
          f[i][j] = f[i][j - 1] + f[i - 1][j];
        }
      }
      //
    }
    System.out.println(f[m - 1][n - 1]);
  }
}
