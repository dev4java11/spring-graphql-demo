package com.spring.graphql.demo1.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.graphql.demo1.domain.Commentary;

public interface CommentaryRepository extends JpaRepository<Commentary, BigInteger> {

	public Commentary findByUuid(String uuid);
	
	public List<Commentary> findByIdPost(BigInteger idPost);
}
