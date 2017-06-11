/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accenture.j2c.bookingcar.reports.hystrix;

import com.accenture.j2c.bookingcar.reports.clientinterface.OrderClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author darren.shuxing.liu
 */
@Component
public class OrderClientHystrix implements OrderClient{
    @Override
    public String getOrderName(@PathVariable("id") String id)
    {
        return "Hystrix works in Feign when BOOKINGCAR-SERVICE is down";
    }
}
