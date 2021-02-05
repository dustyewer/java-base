public class App {
    public static void main(String[] args) throws Exception {
        UserService userServiceImpl = new UserServiceImpl();
        UserService proxy = new UserServiceProxy(userServiceImpl);
        proxy.select();

        System.out.println("Hello, World!");
    }
}
