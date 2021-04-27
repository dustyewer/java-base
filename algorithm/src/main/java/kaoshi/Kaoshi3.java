package kaoshi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Kaoshi3 {
  public static void main(String[] args) {
    //
    String line;
    Kaoshi3 kaoshi3 = new Kaoshi3();
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNextLine()) {
      line = scanner.nextLine().trim();

      System.out.println(kaoshi3.fun3(Integer.valueOf(line)));
    }
  }

  public String fun(int day) {

    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate localDate = LocalDate.parse("1777-04-30", df);
    localDate = localDate.plusDays(day - 1);
    return localDate.toString();
  }

  public String func(int day) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date date = null;
    try {
      date = sdf.parse("1777-04-30");
    } catch (ParseException e) {
      e.printStackTrace();
    }

    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.DATE, day - 1);
    return sdf.format(calendar.getTime());
  }

  public String fun2(int day) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(1777, 3, 30);
    calendar.add(Calendar.DATE, day - 1);
    return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
  }

  public String fun3(int day) {
    int[] mon = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int year = 1777;
    int i = 3;
    day--;
    if (day == 0) {
      return "1777-04-30";
    }
    while (day > mon[i + 1]) {
      i++;
      day -= mon[i];
      if (i == 0) {
        year += 1;
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
          mon[1] = 29;
        } else {
          mon[1] = 28;
        }
      }
      if (i == 11) {
        i = -1;
      }
    }
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(year);
    stringBuilder.append("-");

    if (i < 10) {
      stringBuilder.append("0");
    }
    stringBuilder.append(i + 2);
    stringBuilder.append("-");
    if (day - 1 < 10) {
      stringBuilder.append("0");
    }

    stringBuilder.append(day);

    return stringBuilder.toString();
  }
}
