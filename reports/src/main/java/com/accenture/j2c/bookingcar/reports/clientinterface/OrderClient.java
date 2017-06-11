/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accenture.j2c.bookingcar.reports.clientinterface;

import com.accenture.j2c.bookingcar.reports.hystrix.OrderClientHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author darren.shuxing.liu
 *
 * 本示例使用了Eureka Server作为注册中心，通过FeignClient注解，首先到Eureka Server找到名字为“BOOKINGCAR-SERVICE"的微服务
 * BOOKINGCAR-SERVICE的入口为在Eureka Server注册的入口
 * Feign中内置了对Hystrix的依赖，在FeiClient注解里通过fallback参数声明回调类，
 * 当内部调用失败后，熔断机制会启动，自动调用回调类的同名方法
 * */
 
@FeignClient(name = "BOOKINGCAR-SERVICE", fallback = OrderClientHystrix.class)
public interface OrderClient {
    /*RequestMapping里声明BOOKINGCAR-SERVICE微服务提供的getOrderName的Restful API的入口
     *getOrderName的入口为”{BOOKINGCAR-SERVICE}/v1/order/name/{id}"
     *本示例主要是验证调用其它微服务提供的Restful API接口的能力
     *@Return String
     */
    @RequestMapping(value = "/v1/order/name/{id}", method = RequestMethod.GET)
    public String getOrderName(@PathVariable("id") String id);
}
