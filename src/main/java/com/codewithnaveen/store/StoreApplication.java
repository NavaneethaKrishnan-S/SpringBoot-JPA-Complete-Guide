package com.codewithnaveen.store;

import com.codewithnaveen.store.entities.Profile;
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

		var profile = Profile.builder()
						.bio("Bio")
								.build();

		user.setProfile(profile);
		profile.setUser(user);

		System.out.println(user);

	}
}
