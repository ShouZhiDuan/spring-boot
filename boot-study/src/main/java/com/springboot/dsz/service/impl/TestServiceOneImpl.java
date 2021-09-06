package com.springboot.dsz.service.impl;

import com.springboot.dsz.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @Auther: ShouZhi@Duan
 * @Description:
 */
@Service
public class TestServiceOneImpl implements TestService {

    @Override
    public void say() {
        System.out.println("======one======");
    }
}
