package com.yewer.thread_lock_sync;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class CountDownLatchTest {

  public static void main(String args[]) throws InterruptedException {

    //        CountDownLatch countDownLatch = new CountDownLatch(2);
    //        countDownLatch.wait();

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    try {
      LocalDate localDate = LocalDate.parse("1777-04-30", df);
      Date date = sdf.parse("1777-04-30");
      System.out.println(date.getTime());
      System.out.println(localDate.plusDays(5342));
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(date);
      calendar.add(Calendar.DATE, 5342);
      System.out.println(sdf.format(calendar.getTime()));
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }
}
