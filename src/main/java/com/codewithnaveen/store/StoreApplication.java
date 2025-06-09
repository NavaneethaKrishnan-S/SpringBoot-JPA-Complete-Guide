package com.codewithnaveen.store;

import com.codewithnaveen.store.entities.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
//		ApplicationContext context =  SpringApplication.run(StoreApplication.class, args);
		var user = new User(1L, "name", "email", "password");
		user.setName("John");
		user.setEmail("john@gmail.com");
		user.setPassword("password");

	}

}
