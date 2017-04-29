/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accenture.j2c.gateway.routings;

import java.util.logging.Logger;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author darren.shuxing.liu
 */
@Configuration
public class Routings {
    protected static final Logger logger = Logger.getLogger(Routings.class.getName());
    @Bean
    public PatternServiceRouteMapper serviceRouteMapper() {
        return new PatternServiceRouteMapper(
            "(?<name>^.+)-(?<version>v.+$)",
            "${name}/${version}") {
            @Override
            public String apply(final String serviceId) {                
                String route =  super.apply(serviceId);
                logger.info(String.format("%s -> %s", serviceId, route)); 
               
                return route;
            }
        };
    }
}
