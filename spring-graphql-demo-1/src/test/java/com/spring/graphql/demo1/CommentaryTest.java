package com.spring.graphql.demo1;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.graphql.demo1.domain.Commentary;
import com.spring.graphql.demo1.repository.CommentaryRepository;

public class CommentaryTest extends SpringGraphqlDemo1ApplicationTests {

	@Autowired
	private CommentaryRepository commentaryRepository;

	@Test
	public void test1(){
		List<Commentary> commentaries = commentaryRepository.findAll();
		for(Commentary commentary : commentaries){
			System.out.println(commentary.toString());
		}
	}
}
