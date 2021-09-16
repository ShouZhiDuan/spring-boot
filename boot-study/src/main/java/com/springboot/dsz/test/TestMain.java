package com.springboot.dsz.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: ShouZhi@Duan
 * @Description:
 */
public class TestMain {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("/datanode/listof");
        list.add("bcd");
        System.out.println(list.contains("/datanode/listof"));

        String test = "/datanode/listofxxxxxx";
        System.out.println(test.contains("/datanode/listof**"));
    }
}
