package com.springboot.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * Created by Channing on 2018/3/21.
 */
@RestController

public class DcController {

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    public String getDc(){
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }
}
