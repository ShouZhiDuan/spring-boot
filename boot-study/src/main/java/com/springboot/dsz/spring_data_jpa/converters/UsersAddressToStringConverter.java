package com.springboot.dsz.spring_data_jpa.converters;

import com.alibaba.fastjson.JSON;
import com.springboot.dsz.dto.Address;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @Auther: ShouZhi@Duan
 * @Description: Users实体
 * 参考：http://hantsy.blogspot.com/2013/12/jpa-21-attribute-converter.html
 */
//autoApply = true表示全局实体使用com.springboot.dsz.dto.Address作为属性的时候默认生效。
//如果不配置autoApply = true则需要在实体上去单独生效配置。
@Converter(autoApply = true)
//@Converter //这个配合com.springboot.dsz.spring_data_jpa.entity.Users.address上的注解使用
public class UsersAddressToStringConverter implements AttributeConverter<Address,String> {


    @Override
    public String convertToDatabaseColumn(Address address) {
        return JSON.toJSONString(address);
    }

    @Override
    public Address convertToEntityAttribute(String s) {
        if(StringUtils.isNotBlank(s)){
            Address address = JSON.parseObject(s, Address.class);
            return address;
        }
        return null;
    }
}
