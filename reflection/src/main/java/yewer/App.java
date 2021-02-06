package yewer;

import java.util.Date;
import java.lang.reflect.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Class<?> c1 = Class.forName("yewer.Employee"); // 第1种，forName 方式获取Class对象
        Class<?> c2 = Employee.class;// 第2种，直接通过类获取Class对象
        System.out.println("c1=" + c1 + "\nc2=" + c2);
        Employee employee = new Employee("xiaomin", "22", "code", 1, "java", 10);
        Class<?> c3 = employee.getClass();
        System.out.println("c3=" + c3);

        // 第1种方式：使用Class对象的newInstance()方法来创建Class对象对应类的实例
        Class<?> c = Date.class;
        Date date8 = (Date) c.newInstance(); // java9已经废弃
        Date date9 = (Date) c.getDeclaredConstructor().newInstance();
        System.out.println("date8=" + date8 + "\ndate9=" + date9.getClass());

        // 第2种方式：先通过Class对象获取指定的Constructor对象，再调用Constructor对象的newInstance()方法来创建实例
        long timestamp = date8.getTime();
        Constructor constructor = c.getConstructor(long.class);
        Date date2 = (Date) constructor.newInstance(timestamp);
        System.out.println("date2=" + date2);

        /*-----------------------------------------*/

        String name;
        if (args.length > 0) {
            name = args[0];
        } else {
            Scanner in = new Scanner(System.in);
            System.out.println("输入一个类名（e.g. java.util.Date）："); // reflect.Employee
            name = in.next();
            in.close();
        }
        try {
            Class<?> cl = Class.forName(name);
            Class<?> superCl = cl.getSuperclass();
            String modifiers = Modifier.toString(cl.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print("class " + name);
            if (superCl != null && superCl != Object.class) {
                System.out.print(" extends " + superCl.getName());
            }
            System.out.println("\n{");

            printConstructors(cl); // 打印构造方法
            System.out.println();
            printMethods(cl); // 打印方法
            System.out.println();
            printFields(cl); // 打印属性
            System.out.println("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.exit(0);

    }

    /**
     * 打印Class对象的所有构造方法
     */
    public static void printConstructors(Class cl) {
        Constructor[] constructors = cl.getDeclaredConstructors();

        for (Constructor c : constructors) {
            String name = c.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print(name + "(");
            // 打印构造参数
            Class[] paramTypes = c.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * 打印Class的所有方法
     */
    public static void printMethods(Class cl) {
        Method[] methods = cl.getDeclaredMethods();
        // Method[] methods = cl.getMethods();
        for (Method m : methods) {
            Class retType = m.getReturnType(); // 返回类型
            System.out.print("  ");
            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print(retType.getName() + " " + m.getName() + "(");
            Class[] paramTypes = m.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * 打印Class的所有属性
     */
    public static void printFields(Class cl) {
        Field[] fields = cl.getDeclaredFields();
        for (Field f : fields) {
            Class type = f.getType();
            System.out.print("  ");
            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.println(type.getName() + " " + f.getName() + ";");
        }
    }

}
