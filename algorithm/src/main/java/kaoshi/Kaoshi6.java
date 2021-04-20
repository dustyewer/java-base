package kaoshi;

import java.util.Scanner;

// 找到字符串第一个不重复的字符
public class Kaoshi6 {
  public static void main(String[] args) {
    //
    String line;
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNextLine()) {
      line = scanner.nextLine();
      find(line);
      if ("".equals(line)) {
        break;
      }
    }
  }

  int count[] = new int[256];

  public static int find(String in) {
    for (int i = 0; i < in.length(); i++) {
      //
      System.out.println(Integer.valueOf(in.charAt(i)));
    }
    return 0;
  }
}
