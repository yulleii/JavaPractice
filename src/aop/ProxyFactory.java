package aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    private Object obj;
    public ProxyFactory(Object obj){
        this.obj=obj;
    }
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                new InvocationHandler(){
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("扩展功能1");
                        Object res=method.invoke(obj,args);
                        System.out.println("扩展功能2");
                        return res;
                    }
                });
    }

    public static void main(String[] args) {
        RealSubject subject=new RealSubject();
        ProxyFactory factory=new ProxyFactory(subject);
        Object obj=factory.getProxyInstance();
        Subject proxy=(Subject)obj;
        proxy.action();
        proxy.action();
    }
}
