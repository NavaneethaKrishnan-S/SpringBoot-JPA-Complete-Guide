package com.codewithnaveen.store.repositories;

import com.codewithnaveen.store.entities.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}
