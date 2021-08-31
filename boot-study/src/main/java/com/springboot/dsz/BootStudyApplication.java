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
        System.out.println(beanNamesForType);
    }

}
