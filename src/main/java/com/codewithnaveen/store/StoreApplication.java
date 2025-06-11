package com.codewithnaveen.store;

import com.codewithnaveen.store.entities.User;
import com.codewithnaveen.store.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StoreApplication.class);
		var repository = context.getBean(UserRepository.class);

		var user = User.builder()
				.name("john")
				.email("john@email.com")
				.password("password")
				.build();

		repository.save(user);
	}
}
