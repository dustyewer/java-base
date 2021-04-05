
package main.java.com.yewer.collection;

import java.util.*;

public class CollectionTest {
    public static void main(String[] args) {
        Collection<Object> arrayList = new Vector<>();
        arrayList.add("one");
        arrayList.add(1);
        System.out.println(arrayList);
        System.out.println(arrayList.contains("one"));
        ArrayList<Object> arrayList1 = new ArrayList<>();
        arrayList1.addAll(arrayList);
        System.out.println(arrayList1);

        Iterator<Object> iterator = arrayList.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());

        }



        for (Object o:arrayList ) {            System.out.println(o);        }


    }
}
