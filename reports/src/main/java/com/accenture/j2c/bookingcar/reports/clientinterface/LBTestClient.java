/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accenture.j2c.bookingcar.reports.clientinterface;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author darren.shuxing.liu
 *
 *本示例使用了Eureka Server作为注册中心，通过FeignClient注解，首先到Eureka Server找到名字为“BOOKINGCAR-SERVICE"的微服务
 *BOOKINGCAR-SERVICE的入口为在Eureka Server注册的入口*/
@FeignClient(name = "BOOKINGCAR-SERVICE")
public interface LBTestClient {  
    /*RequestMapping里声明BOOKINGCAR-SERVICE微服务提供的findServicePort的Restful API的入口
     *findServicePort的入口为”{BOOKINGCAR-SERVICE}/v1/lbtest/port/"
     *本示例主要是验证Feign内置的负载均衡能力
     *@Return String
     */
    
    @RequestMapping("/v1/lbtest/port")
    public String findServicePort();
}
