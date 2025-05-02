package com.codewithnaveen.store;


public interface UserRepository {
    void save(User user);
    User findByEmail(String email);
}
