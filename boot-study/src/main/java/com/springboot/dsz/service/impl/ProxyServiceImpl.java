package com.springboot.dsz.service.impl;

import com.springboot.dsz.service.ProxyServcie;

/**
 * @Auther: ShouZhi@Duan
 * @Description:
 */
public class ProxyServiceImpl implements ProxyServcie {
    @Override
    public String pay(String msg) {
        System.out.println(msg);
        return msg;
    }
}
