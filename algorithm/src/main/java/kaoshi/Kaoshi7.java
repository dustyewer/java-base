package kaoshi;

import java.util.Arrays;
import java.util.List;

public class Kaoshi7 {
  public static void main(String[] args) {
    //
    Integer[] a = new Integer[5];
    a[0] = 0;
    List<Integer> aList = Arrays.asList(a);

    for (Integer i : aList) {
      System.out.println(i);
    }

    a[0] = 1;

    for (Integer i : aList) {
      System.out.println(i);
    }
  }
}
