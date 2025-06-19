package com.codewithnaveen.store.services;

import com.codewithnaveen.store.entities.User;
import com.codewithnaveen.store.repositories.AddressRepository;
import com.codewithnaveen.store.repositories.ProfileRepository;
import com.codewithnaveen.store.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final AddressRepository addressRepository;

    private final EntityManager entityManager;

    @Transactional
    public void showEntityState(){
        var user = User.builder()
                .name("NaveenKrishnan")
                .email("naveensarvana8@gmail.com")
                .password("password")
                .build();

        if(entityManager.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient or Detached");

        userRepository.save(user);

        if(entityManager.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient or Detached");
    }

    @Transactional
    public void showRelatedEntities(){
        var profile = profileRepository.findById(1L).orElseThrow();
        System.out.println(profile.getUser().getEmail());
    }

    public void fetchAddress(){
        var address = addressRepository.findById(1L).orElseThrow();
        System.out.println(address.getCity());
    }
}
