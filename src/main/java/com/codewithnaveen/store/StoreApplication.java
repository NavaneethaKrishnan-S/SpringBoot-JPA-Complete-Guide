package com.codewithnaveen.store;

import com.codewithnaveen.store.entities.Address;
import com.codewithnaveen.store.entities.Tag;
import com.codewithnaveen.store.entities.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		var user = User.builder()
				.id(1L)
				.name("Naveen")
				.email("naveensaravana8@gmail.com")
				.build();

		user.addTag("Premium");

		System.out.println(user);

	}
}
