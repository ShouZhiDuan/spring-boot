package com.springboot.dsz.import_demo.slector;

import com.springboot.dsz.dto.User;
import com.springboot.dsz.import_demo.EnableUserByImportSelector;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * @Auther: ShouZhi@Duan
 * @Description: Bean注入逻辑控制
 */
public class UserImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        Map<String, Object> annotationAttributes = annotationMetadata.getAnnotationAttributes(EnableUserByImportSelector.class.getName());
        Class[] o = (Class[]) annotationAttributes.get("exclude");
        for (Class clazz : o){
             if(clazz == User.class){
                 //返回需要注入Bean的类型
                 return new String[] {clazz.getName()};
             }
        }
        return new String[0];
    }
}