package com.spring.graphql.demo1.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.graphql.demo1.domain.User;

public interface UserRepository extends JpaRepository<User, BigInteger> {

	public User findByUuid(String uuid);
}
