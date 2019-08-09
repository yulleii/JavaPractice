package aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//动态代理的使用
public class TestProxy {
    public static void main(String[] args) {
        //1.被代理类的对象
        RealSubject realSubject=new RealSubject();
        //2.创建一个实现了InvocationHandler的对象
        MyInvocationHandler handler=new MyInvocationHandler();
        Object obj=handler.blind(realSubject);
        Subject sub=(Subject)obj;
        sub.action();
    }
}

interface Subject{
      void action();
}

class RealSubject implements Subject{
    public void action(){
        System.out.println("我是被代理类");
    }
}

class MyInvocationHandler implements InvocationHandler{
    Object obj;//实现了接口的被代理类的对象的声明
    //给被代理的对象实例化,并且返回一个代理类的对象
    public Object blind(Object obj){
        this.obj=obj;
        return Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                this);
    }
    //当通过代理类的对象发起对被重写方法的调用时，都对转化为对invoke方法的调用
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Invoke method!");
        Object res=method.invoke(obj,args);
        return res;
    }
}
