package com.spring.graphql.demo1.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.graphql.demo1.domain.Post;

public interface PostRepository extends JpaRepository<Post, BigInteger> {

	public Post findByUuid(String uuid);
}
