package com.springboot.dsz;

import com.alibaba.fastjson.JSON;
import com.springboot.dsz.dto.Address;
import com.springboot.dsz.spring_data_jpa.entity.Users;
import com.springboot.dsz.spring_data_jpa.repository.UsersRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class BootStudyApplicationTests {

    @Autowired
    private UsersRepository usersRepository;

    @Test
    public void saveUsers(){
        Users user = new Users();
        user.setUserName("刘德华");
        user.setAddress(new Address(666666,"浙江省杭州市滨江区东方通信科技园"));
        usersRepository.save(user);
    }

    @Test
    public void queryUsers() {
        List<Users> all = usersRepository.findAll();
        System.out.printf(JSON.toJSONString(all));
    }


}
