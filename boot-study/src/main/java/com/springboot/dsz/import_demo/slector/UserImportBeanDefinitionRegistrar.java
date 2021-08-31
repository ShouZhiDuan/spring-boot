package com.springboot.dsz.import_demo.slector;

import com.springboot.dsz.dto.User;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;

/**
 * @Auther: ShouZhi@Duan
 * @Description:
 */
public class UserImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        Class beanClass = User.class;
        RootBeanDefinition beanDefinition = new RootBeanDefinition(beanClass);


        String beanName = StringUtils.uncapitalize(beanClass.getSimpleName());
        //这些registerBeanDefinition中的bean将被初始化到容器中
        beanDefinitionRegistry.registerBeanDefinition(beanName,beanDefinition);
    }
}
