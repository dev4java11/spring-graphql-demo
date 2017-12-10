package com.spring.graphql.demo1.service;

import java.util.List;

import com.spring.graphql.demo1.model.MPublication;

public interface PublicationService {

	public List<MPublication> findAll();
	
	public MPublication findByPostUUID(String uuid);
}
