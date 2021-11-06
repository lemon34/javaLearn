package refelct.test;

public class ReflectTest {
    public static void main(String[] args) {
        HelloServiceProxy helloServiceProxy = new HelloServiceProxy();
        HelloService proxy = (HelloService) helloServiceProxy.bind(new HelloServiceImpl());
        proxy.sayHello("lemon");
    }

}
