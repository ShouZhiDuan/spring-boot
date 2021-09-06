package com.springboot.dsz.cotroller;

import com.springboot.dsz.dto.User;
import com.springboot.dsz.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
