package com.springboot.dsz.spring_data_jpa.entity;

import com.springboot.dsz.dto.Address;
import com.springboot.dsz.spring_data_jpa.converters.UsersAddressToStringConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Auther: ShouZhi@Duan
 * @Description: 用户实体
 */
@Data
@Entity
@Table(name = "t_users")
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;
    //@Convert(converter = UsersAddressToStringConverter.class)
    private Address address;
}
