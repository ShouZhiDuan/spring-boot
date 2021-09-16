package com.springboot.dsz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Auther: ShouZhi@Duan
 * @Description:
 */
@Data
@AllArgsConstructor
public class Address {
    private int code;
    private String details;
}
