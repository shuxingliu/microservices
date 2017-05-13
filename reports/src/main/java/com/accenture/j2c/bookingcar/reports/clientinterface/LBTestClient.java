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
 */
@FeignClient(name = "BOOKINGCAR-SERVICE")
public interface LBTestClient {        
    @RequestMapping("/v1/lbtest/port")
    public String findServicePort();
}
