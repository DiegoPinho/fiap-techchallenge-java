package com.fiap.java.techchallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.java.techchallenge.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
