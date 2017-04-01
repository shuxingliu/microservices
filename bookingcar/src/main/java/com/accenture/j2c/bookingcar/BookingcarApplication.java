package com.accenture.j2c.bookingcar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *
 * @author darren.shuxing.liu
 * @email  darren.shuxing.liu@accenture.com shuxing.liu@gmail.com
 */
@SpringBootApplication
@EnableEurekaClient
public class BookingcarApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingcarApplication.class, args);
	}
}
