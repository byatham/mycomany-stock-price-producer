package com.sd.tech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
@Slf4j
public class MycomanyStockPriceApplication {
	
	public static void main(String[] args) {
		log.info("MycomanyStockPriceApplication starts ***** ");
		SpringApplication.run(MycomanyStockPriceApplication.class, args);
	}

}