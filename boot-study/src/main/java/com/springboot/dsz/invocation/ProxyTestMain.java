package com.springboot.dsz.invocation;

import com.springboot.dsz.service.ProxyServcie;
import com.springboot.dsz.service.impl.ProxyServiceImpl;

/**
 * @Auther: ShouZhi@Duan
 * @Description:
 */
public class ProxyTestMain {
    public static void main(String[] args) {
        ProxyServcie proxyInstance = new ProxyHandler(new ProxyServiceImpl()).getProxyInstance();
        proxyInstance.pay("我要买奔驰！！！！！！");
    }
}
