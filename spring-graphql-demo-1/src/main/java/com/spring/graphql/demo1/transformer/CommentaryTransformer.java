package com.spring.graphql.demo1.transformer;

import com.spring.graphql.demo1.domain.Commentary;
import com.spring.graphql.demo1.model.MCommentary;
import com.spring.graphql.demo1.util.ApplicationUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentaryTransformer extends AbstractTransformer<Commentary, MCommentary>{
	
	private UserTransformer userTransformer;
	
	private PostTransformer postTransformer;
	
	@Autowired
	public void setUserTransformer(UserTransformer userTransformer) {
		this.userTransformer = userTransformer;
	}
	
	@Autowired
	public void setPostTransformer(PostTransformer postTransformer) {
		this.postTransformer = postTransformer;
	}

	@Override
	protected MCommentary transformSource(Commentary source) {
		MCommentary target = new MCommentary();
		target.setUuid(source.getUuid());
		target.setDescription(source.getDescription());
		target.setPublish(ApplicationUtil.buildMDateWithFormatDateTime(source.getPublish()));
		target.setUser(userTransformer.transformToTarget(source.getUser()));
		target.setPost(postTransformer.transformToTarget(source.getPost()));
		return target;
	}
	
	@Override
	protected Commentary transformTarget(MCommentary target) {
		Commentary source = new Commentary();
		source.setUuid(target.getUuid());
		source.setDescription(target.getDescription());
		source.setPublish(ApplicationUtil.buildDateFromMDate(target.getPublish()));
		source.setUser(userTransformer.transformToSource(target.getUser()));
		source.setPost(postTransformer.transformToSource(target.getPost()));
		return source;
	}

}
