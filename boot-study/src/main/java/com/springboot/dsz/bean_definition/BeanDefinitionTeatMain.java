package com.springboot.dsz.bean_definition;

import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @Auther: ShouZhi@Duan
 * @Description:
 * 参考：https://blog.csdn.net/meism5/article/details/113913388?utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1.no_search_link&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1.no_search_link
 */
public class BeanDefinitionTeatMain {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        /**
         * 1、BeanDefinitionBuilder构建方式
         */
        BeanDefinitionBuilder builder = BeanDefinitionBuilder
                .genericBeanDefinition(TestBean.class)
                .addPropertyValue("txt","这是一条测试语句");
        beanFactory.registerBeanDefinition("testBean1",builder.getBeanDefinition());
        TestBean testBean1 = beanFactory.getBean("testBean1", TestBean.class);
        System.out.println(testBean1.getTxt());
        /**
         * 2、直接new方式
         */
        RootBeanDefinition beanDefinition = new RootBeanDefinition(TestBean.class);
        ConstructorArgumentValues constructorArgumentValues = new ConstructorArgumentValues();
        constructorArgumentValues.addIndexedArgumentValue(0,"这又是一条新的测试语句");
        beanDefinition.setConstructorArgumentValues(constructorArgumentValues);
        beanFactory.registerBeanDefinition("testBean2",beanDefinition);
        TestBean testBean2 = beanFactory.getBean("testBean2", TestBean.class);
        System.out.println(testBean2.getTxt());
    }
}
