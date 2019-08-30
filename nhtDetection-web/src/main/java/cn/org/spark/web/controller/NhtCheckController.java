package cn.org.spark.web.controller;

import cn.org.spark.biz.service.NhtCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by Anonymous on 2019/8/30.
 */

@RestController
@RequestMapping("NhtCheck")
public class NhtCheckController {
    @Autowired
    private NhtCheckService nhtCheckService;

    //@GetMapping("checkIpV4Str")
    @RequestMapping(value = "checkIpV4Str", produces = "application/json;charset=UTF-8")
    public String checkIpV4Str(String ipV4Str) {
        return nhtCheckService.checkIpV4Str(ipV4Str);
    }
}
