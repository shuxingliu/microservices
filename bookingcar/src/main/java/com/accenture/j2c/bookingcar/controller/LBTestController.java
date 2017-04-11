/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accenture.j2c.bookingcar.controller;

import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author darren.shuxing.liu
 */
@RestController
@RequestMapping("/v1/lbtest")

public class LBTestController {
    /**
     *
     */
    protected static final Logger logger = Logger.getLogger(LBTestController.class.getName());
    
    @Value("${server.port}")
    String port;
    @RequestMapping("port")
    public String findServicePort()
    {
        String prompt = String.format("Ribbon (load balancer) service test, port = {%s} ", 
                port);
        logger.info(prompt);
        return prompt;
    }    
}
