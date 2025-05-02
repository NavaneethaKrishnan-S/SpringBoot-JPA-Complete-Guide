package com.codewithnaveen.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(StoreApplication.class, args);
		var userService = context.getBean(UserService.class);
		userService.registerUser(new User(1L, "naveensaravana8@gmail.com", "Naveen@007", "Naveen"));
		userService.registerUser(new User(2L, "naveensaravana7@gmail.com", "Naveen@007", "Naveen"));
	}

}
