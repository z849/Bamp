package com.aaa.hgspringbootmybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(basePackages = {"com.aaa.hgspringbootmybatis.dao"})
public class HgSpringbootMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(HgSpringbootMybatisApplication.class, args);
    }

}
