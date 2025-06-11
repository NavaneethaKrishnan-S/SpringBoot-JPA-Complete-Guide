package com.codewithnaveen.store.repositories;

import com.codewithnaveen.store.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
