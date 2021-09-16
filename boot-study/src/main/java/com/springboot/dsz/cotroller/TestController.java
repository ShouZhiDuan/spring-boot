package com.springboot.dsz.cotroller;

import com.alibaba.fastjson.JSON;
import com.springboot.dsz.dto.Address;
import com.springboot.dsz.dto.User;
import com.springboot.dsz.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: ShouZhi@Duan
 * @Description:
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    @Qualifier("user")
    private User user;

    //@Autowired
    private TestService testService;


    @GetMapping("/1")
    public Object test(){
        return user;
    }

    @PostMapping("/params")
    public Object test2(@RequestBody String token, @RequestBody Address address){
        System.out.println(token);
        System.out.println(JSON.toJSONString(address));
        return token;
    }


}
