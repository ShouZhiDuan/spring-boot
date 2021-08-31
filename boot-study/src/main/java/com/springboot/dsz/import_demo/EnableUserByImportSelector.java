package com.springboot.dsz.import_demo;

import com.springboot.dsz.import_demo.slector.UserImportBeanDefinitionRegistrar;
import com.springboot.dsz.import_demo.slector.UserImportSelector;
import org.springframework.context.annotation.Import;
import java.lang.annotation.*;

/**
 * @Auther: ShouZhi@Duan
 * @Description:
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({UserImportSelector.class, UserImportBeanDefinitionRegistrar.class})
public @interface EnableUserByImportSelector {
    //自定义bean注入逻辑的控制参数
    Class<?>[] exclude() default {};
}
