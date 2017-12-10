package com.spring.graphql.demo1.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.graphql.demo1.domain.Commentary;
import com.spring.graphql.demo1.domain.Post;
import com.spring.graphql.demo1.model.MPublication;
import com.spring.graphql.demo1.repository.CommentaryRepository;
import com.spring.graphql.demo1.repository.PostRepository;
import com.spring.graphql.demo1.service.PublicationService;
import com.spring.graphql.demo1.transformer.CommentaryTransformer;
import com.spring.graphql.demo1.transformer.PostTransformer;
import com.spring.graphql.demo1.util.ApplicationUtil;
import com.spring.graphql.demo1.util.ValidationUtil;

@Service
@Transactional(readOnly = true)
public class PublicationServiceImpl implements PublicationService {
	
	private PostRepository postRepository;
	
	private CommentaryRepository commentaryRepository;
	
	private PostTransformer postTransformer;
	
	private CommentaryTransformer commentaryTransformer;

	@Override
	public List<MPublication> findAll() {
		List<MPublication> publications = ApplicationUtil.getNewArrayList();
		List<Post> posts = postRepository.findAll();
		Date date = new Date();
		publications = buildListPublications(publications, posts, date, commentaryRepository);
		return publications;
	}

	@Override
	public MPublication findByPostUUID(String uuid) {
		List<MPublication> publications = ApplicationUtil.getNewArrayList();
		Post post = postRepository.findByUuid(uuid);
		Date date = new Date();
		if(ValidationUtil.isNotNull(post)){
			publications = buildListPublications(publications, Arrays.asList(post), date, commentaryRepository);
		}
		MPublication publication = null;
		if(ValidationUtil.isEmpty(publications)){
			publication = null;
		}else{
			publication = publications.get(0);
		}
		
		return publication;
	}
	
	
	public List<MPublication> buildListPublications(List<MPublication> publications, List<Post> posts, Date date, CommentaryRepository commentaryRepository){
		if(ValidationUtil.isNotEmpty(posts)){
			for(Post post : posts){
				List<Commentary> commentaries = commentaryRepository.findByIdPost(post.getIdPost());
				
				MPublication publication = new MPublication();
				publication.setUuid(ApplicationUtil.generateRandomUUID());
				publication.setQueryDate(ApplicationUtil.buildMDateWithFormatTime(date));
				publication.setPost(postTransformer.transformToTarget(post));
				publication.setComentaries(commentaryTransformer.transformToTarget(commentaries));
				
				publications.add(publication);
			}
		}
		return publications;
	}

	@Autowired
	public void setPostRepository(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	@Autowired
	public void setCommentaryRepository(CommentaryRepository commentaryRepository) {
		this.commentaryRepository = commentaryRepository;
	}
	
	@Autowired
	public void setPostTransformer(PostTransformer postTransformer) {
		this.postTransformer = postTransformer;
	}
	
	@Autowired
	public void setCommentaryTransformer(CommentaryTransformer commentaryTransformer) {
		this.commentaryTransformer = commentaryTransformer;
	}
}
