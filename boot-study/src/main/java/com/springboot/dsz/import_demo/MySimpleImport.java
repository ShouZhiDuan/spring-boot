package com.springboot.dsz.import_demo;

import com.springboot.dsz.dto.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Auther: ShouZhi@Duan
 * @Description:
 */
@Import(User.class)//导入User类型的bean到容器中
@Configuration//需要配合使用，单独import无效
public class MySimpleImport {

}
