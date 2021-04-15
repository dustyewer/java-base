import java.util.Iterator;


import java.util.ArrayList;
import java.util.Collections;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        // 创建集合
        ArrayList<String> myArrayList = new ArrayList<String>();
        myArrayList.add("Google");
        myArrayList.add("Runoob");
        myArrayList.add("Taobao");
        myArrayList.add("Zhihu");
        myArrayList.add("1");

        Iterator<String> it = myArrayList.iterator();

        System.out.println(it.next());

        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("--------------------");

        Collections.sort(myArrayList);

        for (String s : myArrayList) {
            System.out.println(s);
        }
        System.out.println("--------------------");
        myArrayList.stream().forEach(System.out::println);
    }
}
