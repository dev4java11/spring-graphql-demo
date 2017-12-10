package com.spring.graphql.demo1.transformer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.graphql.demo1.domain.Post;
import com.spring.graphql.demo1.model.MPost;
import com.spring.graphql.demo1.util.ApplicationUtil;

@Component
public class PostTransformer extends AbstractTransformer<Post, MPost> {
	
	private UserTransformer userTransformer;
	
	@Autowired
	public void setUserTransformer(UserTransformer userTransformer) {
		this.userTransformer = userTransformer;
	}

	@Override
	protected MPost transformSource(Post source) {
		MPost target = new MPost();
		target.setUuid(source.getUuid());
		target.setTitle(source.getTitle());
		target.setDescription(source.getDescription());
		target.setPublish(ApplicationUtil.buildMDateWithFormatDateTime(source.getPublish()));
		target.setUser(userTransformer.transformToTarget(source.getUser()));
		return target;
	}

	@Override
	protected Post transformTarget(MPost target) {
		Post source = new Post();
		source.setUuid(target.getUuid());
		source.setTitle(target.getTitle());
		source.setDescription(target.getDescription());
		source.setPublish(ApplicationUtil.buildDateFromMDate(target.getPublish()));
		source.setUser(userTransformer.transformToSource(target.getUser()));
		return source;
	}

	

}
