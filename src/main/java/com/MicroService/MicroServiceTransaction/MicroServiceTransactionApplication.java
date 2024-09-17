package com.MicroService.MicroServiceTransaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroServiceTransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceTransactionApplication.class, args);
	}

}
