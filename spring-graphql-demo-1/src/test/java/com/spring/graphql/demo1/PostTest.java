package com.spring.graphql.demo1;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.graphql.demo1.domain.Post;
import com.spring.graphql.demo1.repository.PostRepository;

public class PostTest extends SpringGraphqlDemo1ApplicationTests{

	@Autowired
	private PostRepository postRepository;
	
	@Test
	public void test1(){
		List<Post> posts = postRepository.findAll();
		for(Post post : posts){
			System.out.println(post.toString());
		}
	}
}
