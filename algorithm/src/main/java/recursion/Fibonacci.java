package recursion;
// 1 2 3 5 8 13 21 34 55 89
public class Fibonacci {
  public static void main(String[] args) {
    //
      Fibonacci fibonacci = new Fibonacci();
    System.out.println(fibonacci.f(10));
  }

  public int f(int n){
    if (n == 1) {
      return 1;
      }else if(n==2){
        return 2;
    }else{
        return f(n-1)+f(n-2);
    }

  }
}
