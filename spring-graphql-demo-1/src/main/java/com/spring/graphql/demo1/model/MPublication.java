package com.spring.graphql.demo1.model;

import java.util.List;

public class MPublication {

	private String uuid;
	private MPost post;
	private List<MCommentary> comentaries;
	private MDate queryDate;
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public MPost getPost() {
		return post;
	}
	public void setPost(MPost post) {
		this.post = post;
	}
	public List<MCommentary> getComentaries() {
		return comentaries;
	}
	public void setComentaries(List<MCommentary> comentaries) {
		this.comentaries = comentaries;
	}
	public MDate getQueryDate() {
		return queryDate;
	}
	public void setQueryDate(MDate queryDate) {
		this.queryDate = queryDate;
	}
	
	
	
	
	
}
