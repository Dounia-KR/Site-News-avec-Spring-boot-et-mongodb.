package com.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.models.User;

public interface UserRepository extends MongoRepository<User, String> {
    String findByLogin(String login);
    boolean existsByLogin(String login);
    User findBylogin(String login);

}
