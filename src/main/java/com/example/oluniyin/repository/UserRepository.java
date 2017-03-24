package com.example.oluniyin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.oluniyin.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String email);

}
