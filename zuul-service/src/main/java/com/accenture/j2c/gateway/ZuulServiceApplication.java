package com.accenture.j2c.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableZuulProxy
@ComponentScan
public class ZuulServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ZuulServiceApplication.class, args);
	}
        
        @RefreshScope
        @ConfigurationProperties("bookingcar")
        public ZuulProperties zuulProperties() {
            return new ZuulProperties();
        }
}
