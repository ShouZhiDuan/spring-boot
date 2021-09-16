package com.springboot.dsz.bean_processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Auther: ShouZhi@Duan
 * @Description: Bean
 */
@Component
public class BeanTest implements InstantiationAwareBeanPostProcessor {
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if(beanName.contains("user")){
          //  System.err.println("before init: [" + beanName  + "]" + bean.getClass());
        }
        return null;
    }
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.contains("user")){
            System.err.println("after init: [" + beanName  + "]" + bean.getClass());
        }
        return bean;
    }
}
