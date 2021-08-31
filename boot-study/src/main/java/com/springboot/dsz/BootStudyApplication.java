package com.springboot.dsz;

import com.springboot.dsz.dto.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BootStudyApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(BootStudyApplication.class, args);
        String[] beanNamesForType = run.getBeanNamesForType(User.class);
        //遍历所有User.class类型的bean的名称
        for (String name : beanNamesForType){
            System.out.println(name);
        }
    }

}
