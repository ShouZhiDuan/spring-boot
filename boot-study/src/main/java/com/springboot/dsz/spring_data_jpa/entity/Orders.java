package com.springboot.dsz.spring_data_jpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * @Auther: ShouZhi@Duan
 * @Description:
 */
@Data
@Entity
@Table(name = "t_orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 20)
    private String name;

    @Column(nullable = false)
    private Timestamp creted;

    private Date date;
}
