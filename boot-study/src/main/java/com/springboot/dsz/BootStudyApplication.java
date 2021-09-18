package com.springboot.dsz;

import com.springboot.dsz.dto.User;
import com.springboot.dsz.import_demo.EnableUserByImportSelector;
import com.springboot.dsz.service.TestService;
import com.springboot.dsz.spring_data_jpa.repository.UsersRepository;
import com.starter.login.service.LoginService;
import com.starter.login.service.impl.LoginServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
@Slf4j
@SpringBootApplication
/**指定扫描包路径*/
//@ComponentScan(value = {"com.starter.login.service.impl"})
/**自定义初始化组件*/
@EnableUserByImportSelector(exclude = User.class)
/**加载子模块配置文件*/
//@PropertySource(value = {"application_login.properties"})
public class BootStudyApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(BootStudyApplication.class, args);
        ConfigurableListableBeanFactory beanFactory = run.getBeanFactory();
        Class clazz;
        //clazz = LoginServiceImpl.class;
        clazz = UsersRepository.class;
        //clazz = User.class;
        //1、查看相关bean
        String[] beanNamesForType = run.getBeanNamesForType(clazz);
        System.out.println(beanNamesForType.length);
        for (String name : beanNamesForType){
            System.out.println(name);
//            LoginService loginService = (LoginService) beanFactory.getBean(name, clazz);
//            loginService.login();
        }
        //2、跨模块环境变量
        String property = run.getEnvironment().getProperty("starter.key");
        System.out.println(property);
        //3、TestService.class
        //TestService bean = beanFactory.getBean(TestService.class);
        //BeanDefinition beanDefinition = beanFactory.getBeanDefinition("com.springboot.dsz.service.TestService");
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        String[] beanNamesForType1 = beanFactory.getBeanNamesForType(TestService.class);
        log.error("======启动完成======");
    }

}
