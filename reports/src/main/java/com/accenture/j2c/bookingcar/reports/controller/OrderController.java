/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accenture.j2c.bookingcar.reports.controller;

import com.accenture.j2c.bookingcar.reports.clientinterface.OrderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author darren.shuxing.liu
 */
@RestController
@RequestMapping("/v1")
public class OrderController {
    //注入OrderClient接口
    @Autowired
    OrderClient oclient; 
    //通过对OrderClient接口getOrderName方法的调用，实现对另一个微服务BOOKINGCAR-SERVICE开放的Restful API的调用
    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public String feign_getOrderName(@PathVariable("id") String id) {
        return oclient.getOrderName(id);
    }
}
