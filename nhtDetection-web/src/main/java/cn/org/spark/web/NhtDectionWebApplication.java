package cn.org.spark.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Anonymous on 2019/8/27.
 */
@SpringBootApplication(scanBasePackages = "cn.org.spark")
@MapperScan("cn.org.spark.dao")
public class NhtDectionWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(NhtDectionWebApplication.class, args);
    }
}