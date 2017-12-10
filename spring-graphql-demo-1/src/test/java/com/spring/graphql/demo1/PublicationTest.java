package com.spring.graphql.demo1;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.graphql.demo1.model.MPublication;
import com.spring.graphql.demo1.service.PublicationService;
import com.spring.graphql.demo1.util.ValidationUtil;

public class PublicationTest extends SpringGraphqlDemo1ApplicationTests {

	@Autowired
	private PublicationService publicationService;
	
	@Test
	@Ignore
	public void test1(){
		List<MPublication> publications = publicationService.findAll();
		if(ValidationUtil.isNotEmpty(publications)){
			for(MPublication publication : publications){
				System.out.println(publication.toString());
			}
		}
	}
}
