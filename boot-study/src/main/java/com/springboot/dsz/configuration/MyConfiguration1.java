package com.springboot.dsz.configuration;

import com.springboot.dsz.dto.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @Auther: ShouZhi@Duan
 * @Description:
 */
@Configuration
public class MyConfiguration1 {

    @Bean
    public User user1(){
        User user = new User();
        user.setName("name1");
        user.setAddr("addr1");
        return user;
    }

    @Bean
    @Primary //表示：同一类型的bean默认杯注入的标记
    public User user2(){
        User user = new User();
        user.setName("name2");
        user.setAddr("addr2");
        return user;
    }

}
