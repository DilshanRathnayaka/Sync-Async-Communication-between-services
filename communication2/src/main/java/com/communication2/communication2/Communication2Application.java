package com.communication2.communication2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Communication2Application {

	public static void main(String[] args) {
		SpringApplication.run(Communication2Application.class, args);
	}

}
