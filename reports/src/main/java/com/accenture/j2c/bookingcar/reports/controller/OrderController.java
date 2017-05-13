/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accenture.j2c.bookingcar.reports.controller;

import com.accenture.j2c.bookingcar.reports.clientinterface.LBTestClient;
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
    @Autowired
    LBTestClient lbtclient;
    
    @Autowired
    OrderClient oclient;
    
        
    @RequestMapping(value = "/port", method = RequestMethod.GET)
    public String getPort() {
        return lbtclient.findServicePort();
    }
    
    
    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public String getOrderName(@PathVariable("id") String id) {
        return oclient.getOrderName(id);
    }
}
