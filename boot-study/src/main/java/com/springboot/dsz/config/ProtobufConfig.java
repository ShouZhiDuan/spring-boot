package com.springboot.dsz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;

/**
 * @Auther: ShouZhi@Duan
 * @Description:
 */
@Configuration
public class ProtobufConfig {
      @Bean
    ProtobufHttpMessageConverter protobufHttpMessageConverter(){
          return new ProtobufHttpMessageConverter();
      }
}
