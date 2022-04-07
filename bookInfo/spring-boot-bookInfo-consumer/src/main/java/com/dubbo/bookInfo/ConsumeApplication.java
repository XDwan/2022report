package com.dubbo.bookInfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: XDwan
 * @Date:2022/4/3
 * @Description:
 **/
//@RestController
@SpringBootApplication
public class ConsumeApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumeApplication.class,args);
    }
//
//    @RequestMapping("/")
//    public String home(){
//        return "Test mapping";
//    }
}
