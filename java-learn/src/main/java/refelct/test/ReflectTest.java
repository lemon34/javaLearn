package refelct.test;

public class ReflectTest {
    public static void main(String[] args) {
        // jdk 代理
        HelloServiceProxy helloServiceProxy = new HelloServiceProxy();
        HelloService proxyJdk = (HelloService) helloServiceProxy.bind(new HelloServiceImpl());
        proxyJdk.sayHello("lemon");
        //cglib 代理
        HelloServiceCglib helloServiceCglib = new HelloServiceCglib();
        HelloService proxyCglib = (HelloService)helloServiceCglib.getInstance(new HelloServiceImpl());
        proxyCglib.sayHello("lemon");
    }

}
