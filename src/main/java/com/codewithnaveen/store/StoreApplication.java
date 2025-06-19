package com.codewithnaveen.store;

import com.codewithnaveen.store.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StoreApplication.class);

		var userService = context.getBean(UserService.class);
		userService.fetchAddress();
	}
}
