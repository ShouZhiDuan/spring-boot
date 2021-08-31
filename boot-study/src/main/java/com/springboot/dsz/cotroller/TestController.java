package com.springboot.dsz.cotroller;

import com.springboot.dsz.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
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
    private User user;


    @GetMapping("/1")
    public Object test(){
        return user;
    }


}
