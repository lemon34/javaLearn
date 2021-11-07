package refelct.test;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class HelloServiceCglib implements MethodInterceptor {

    private Object target;

    /**
     * cglib 是生成被代理类的一个子类，利用该子类进行对象代理
     * @param target
     * @return
     */
    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }


    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("这是cglib 代理开始");
        Object returnObj = methodProxy.invokeSuper(o, objects);
        System.out.println("这是cglib 代理结束");
        return returnObj;
    }
}
