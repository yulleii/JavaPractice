package aop;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    private Object target;
    public CglibProxy(Object target){
        this.target=target;
    }

    public Object getProxyInstance(){
        Enhancer en=new Enhancer();
        en.setSuperclass(target.getClass());
        en.setCallback(this);
        return en.create();
    }
    public Object intercept(Object obj, Method method, Object[]args, MethodProxy proxy)throws Throwable{
        System.out.println("开始事务");
        Object returnValue=method.invoke(target,args);
        System.out.println("提交事务");
        return returnValue;
    }

    public static void main(String[] args) {
        App app=new App();
        CglibProxy c=new CglibProxy(app);
        App appProxy=(App)c.getProxyInstance();
        appProxy.save();
    }
}
class App{
    public void save(){
        System.out.println("已经保存数据");
    }
}

