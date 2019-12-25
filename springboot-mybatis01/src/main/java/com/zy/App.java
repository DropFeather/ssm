package com.zy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

/**
 * @author zy
 * @Date 2019-12-24 23:39
 */
@SpringBootApplication
@MapperScan("com.zy.mapper")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
