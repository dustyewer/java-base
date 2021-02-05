package yewer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

public class LogHandler implements InvocationHandler {

    Object target; // 被代理的对象，实际的方法执行者

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        befor();
        Object result = method.invoke(target, args); // 调用 target 的 method 方法
        after();
        return result;
    }

    public void befor() {
        System.out.println(String.format("log start time [%s] ", new Date()));
    }

    public void after() {
        System.out.println(String.format("log end time [%s] ", new Date()));
    }

    public LogHandler(Object target) {
        this.target = target;
    }

}
