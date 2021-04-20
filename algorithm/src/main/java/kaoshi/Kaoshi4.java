package kaoshi;

import java.util.Scanner;

// 表达式括号匹配
public class Kaoshi4 {
  public static void main(String[] args) {
    //
    String input;
    Scanner scanner = new Scanner(System.in);
    Kaoshi4 kaoshi4 = new Kaoshi4();
    while (scanner.hasNextLine()) {
      input = scanner.nextLine();

      System.out.println(kaoshi4.fun(input));
      if ("".equals(input)) {
        break;
      }
    }
  }

  public boolean fun(String arr) {

    int count = 0;
    for (int i = 0; i < arr.length(); i++) {
      if ('(' == arr.charAt(i)) {

        count++;
      }
      if (')' == arr.charAt(i)) {
        count--;
        if (count < 0) {
          return false;
        }
      }
    }
    return count != 0 ? false : true;

    //
  }
}
