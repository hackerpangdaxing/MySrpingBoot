package com.springboot.main.main;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Description: 服务发现（Eureka） 通过@EnableEurekaServer注解启动一个服务注册中心提供给其他应用进行对话
 * Created by Channing on 2018/3/21.
 */

@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaApplication.class).web(true).run(args);
        System.out.println("hello");
    }



}
