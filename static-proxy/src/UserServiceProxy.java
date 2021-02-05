import java.util.Date;

public class UserServiceProxy implements UserService {

    private UserService target; // 被代理的对象

    

    @Override
    public void select() {
        befor();
        target.select();
        after();

    }

    @Override
    public void update() {
        befor();
        target.update();
        after();

    }

    public void befor() {
        System.out.println(String.format("log start time [%s] ", new Date()));
    }

    public void after() {
        System.out.println(String.format("log end time [%s] ", new Date()));
    }

    public UserServiceProxy(UserService target) {
        this.target = target;
    }
}
