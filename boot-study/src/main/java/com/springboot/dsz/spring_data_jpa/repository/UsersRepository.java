package com.springboot.dsz.spring_data_jpa.repository;

import com.springboot.dsz.spring_data_jpa.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: ShouZhi@Duan
 * @Description:
 */
public interface UsersRepository extends JpaRepository<Users,Integer> {
}
