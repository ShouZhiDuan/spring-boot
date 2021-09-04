package com.springboot.dsz.invocation;

import org.springframework.util.Assert;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther: ShouZhi@Duan
 * @Description:
 */
public class ProxyHandler implements InvocationHandler {

    private Object target;

    public ProxyHandler(Object object){
        Assert.notNull(object, "请输入实现类");
        this.target = object;
    }

    /**
     * 获取代理类
     */
    public <T> T  getProxyInstance(){
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    /**
     * 最终代理方法
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("======开始代理======");
        Object invoke = method.invoke(target, args);
        System.out.println("======执行返回结果为：" + invoke.toString());
        System.out.println("======结束代理======");
        return null;
    }
}
