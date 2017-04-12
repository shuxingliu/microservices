/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accenture.j2c.loadbalance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author darren.shuxing.liu
 */
@Service
public class LoadBalanceService {
    @Autowired 
    RestTemplate restTemplate;
    public String TestPort(String microserviceName) {
        String uri = String.format("http://%s/v1/lbtest/port", microserviceName);
        return restTemplate.getForObject(uri, String.class);
    }
    
    public String TestGetOrderByUserId(String microserviceName, String userId) {
        String uri = String.format("http://%s/v1/order?userid=%s", 
                microserviceName, userId);
        return restTemplate.getForObject(uri, String.class);
    }
}