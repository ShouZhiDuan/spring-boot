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
        return new User("name1","addr1");
    }

    @Bean
    @Primary //表示：同一类型的bean默认杯注入的标记
    public User user2(){
        return new User("name2","addr2");
    }

}
