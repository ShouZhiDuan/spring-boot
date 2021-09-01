package com.springboot.dsz;

import com.springboot.dsz.dto.User;
import com.springboot.dsz.import_demo.EnableUserByImportSelector;
import com.starter.login.service.LoginService;
import com.starter.login.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@ComponentScan(value = {"com.starter.login.service.impl"})
@EnableUserByImportSelector(exclude = User.class)
@PropertySource(value = {"application_login.properties"})
public class BootStudyApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(BootStudyApplication.class, args);
        ConfigurableListableBeanFactory beanFactory = run.getBeanFactory();
        Class clazz;
        clazz = LoginServiceImpl.class;
        //clazz = User.class;
        //查看相关bean
        String[] beanNamesForType = run.getBeanNamesForType(clazz);
        System.out.println(beanNamesForType.length);
        for (String name : beanNamesForType){
            System.out.println(name);
            LoginService loginService = (LoginService) beanFactory.getBean(name, clazz);
            loginService.login();
        }
        //跨模块环境变量
        String property = run.getEnvironment().getProperty("starter.key");
        System.out.println(property);
    }

}
