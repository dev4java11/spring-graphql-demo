package com.spring.graphql.demo1;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.graphql.demo1.domain.User;
import com.spring.graphql.demo1.repository.UserRepository;

public class UserTest extends SpringGraphqlDemo1ApplicationTests {
	
	@Autowired
	private UserRepository userRepository;

	@Test
	public void test1(){
		List<User> users = userRepository.findAll();
		for(User user : users){
			System.out.println(user.toString());
		}
	}
}
