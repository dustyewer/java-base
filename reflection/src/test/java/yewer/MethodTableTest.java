package yewer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class MethodTableTest {

    @Test
    public void methodTableTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Employee employee = new Employee("小明", "18", "写代码", 1, "Java攻城狮", 100000);
        Method sayHello = employee.getClass().getMethod("sayHello");
        System.out.println(sayHello); // 打印 sayHello 的方法信息
        sayHello.invoke(employee); // 让 employee 执行 sayHello 方法        

        double x = 3.0;
        Method square = MethodTableTest.class.getMethod("square", double.class); // 获取 MethodTableTest 的square方法
        double y1 = (double) square.invoke(null, x); // 调用类方法 square 求平方，方法参数 x
        System.out.printf("square    %-10.4f -> %10.4f%n", x, y1);

        Method sqrt = Math.class.getMethod("sqrt", double.class); // 获取 Math 的 sqrt 方法
        double y2 = (double) sqrt.invoke(null, x); // 调用类方法 sqrt 求根，方法参数 x
        System.out.printf("sqrt      %-10.4f -> %10.4f%n", x, y2);

    }

    public static double square(double x) {
        return x * x;
    }
}
