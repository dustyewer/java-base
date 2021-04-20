package kaoshi;

import java.util.Scanner;

// 判断回文字符串
public class Kaoshi5 {
  public static void main(String[] args) {
    //
    String input;
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNextLine()) {
      input = scanner.nextLine();

      String aa = "223 3 #d 的 是个很__  EEE=+";
      aa = aa.replaceAll("[^a-zA-Z0-9\\u4E00-\\u9FA5]", ""); // 去除数字，英文，汉字  之外的内容
      System.out.println(aa); // 输出为   2233d的是个很EEE

      aa.replaceAll("[\\s*|\t|\r|\n]", ""); // 去除所有空格，制表符
      System.out.println(aa);
      aa.toUpperCase();
      System.out.println(aa);

      StringBuilder sb = new StringBuilder(input);
      String reverser = sb.reverse().toString();

      if (reverser.equals(input)) {
        System.out.println("true");
      } else {
        System.out.println("false");
      }

      if ("".equals(input)) {
        break;
      }
    }
  }
}
