package kaoshi;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Kaoshi3 {
  public static void main(String[] args) {
    //
      String line;
      Kaoshi3 kaoshi3 = new Kaoshi3();
      Scanner scanner =new Scanner(System.in);
    while (scanner.hasNextLine()) {
      line = scanner.nextLine().trim();

      System.out.println(kaoshi3.fun(Integer.valueOf(line)));
          }
  }


  public String fun(int day){

      DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      LocalDate localDate = LocalDate.parse("1777-04-30",df);
      localDate= localDate.plusDays(day-1);
      return localDate.toString();
  }
}
