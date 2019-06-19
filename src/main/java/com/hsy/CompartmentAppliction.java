package com.hsy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 张梓枫
 * @date 2019年5月22日下午1:35:01
 * @description
 */
@EnableEurekaClient
@SpringBootApplication
public class CompartmentAppliction {
	public static void main(String[] args) {
		SpringApplication.run(CompartmentAppliction.class, args);
	}
}
