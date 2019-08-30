package cn.org.spark.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.org.spark.biz.service.HelloService;

/**
 * Created by Anonymous on 2019/8/27.
 */

@RestController
@RequestMapping("hello")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("test")
    public String test() {
        return helloService.test();
    }


}