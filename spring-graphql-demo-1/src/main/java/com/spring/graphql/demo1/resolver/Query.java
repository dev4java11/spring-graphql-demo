package com.spring.graphql.demo1.resolver;

import java.util.List;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.spring.graphql.demo1.model.MPublication;
import com.spring.graphql.demo1.service.PublicationService;

@Component
public class Query implements GraphQLQueryResolver {

	private PublicationService publicationService;
	
	public Query(PublicationService publicationService){
		this.publicationService = publicationService;
	}
	
	public List<MPublication> getPublications(){
		return publicationService.findAll();
	}
	
	public MPublication getPublicationByPostUUID(String uuid){
		return publicationService.findByPostUUID(uuid);
	}
}
