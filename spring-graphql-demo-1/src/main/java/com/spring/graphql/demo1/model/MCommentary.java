package com.spring.graphql.demo1.model;

public class MCommentary {

	private String uuid;
	private String description;
	private MDate publish;
	private MUser user;
	private MPost post;
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public MDate getPublish() {
		return publish;
	}
	public void setPublish(MDate publish) {
		this.publish = publish;
	}
	public MUser getUser() {
		return user;
	}
	public void setUser(MUser user) {
		this.user = user;
	}
	public MPost getPost() {
		return post;
	}
	public void setPost(MPost post) {
		this.post = post;
	}
	
	@Override
	public String toString() {
		return "MCommentary [uuid=" + uuid + ", description=" + description + ", publish=" + publish + ", user=" + user
				+ ", post=" + post + "]";
	}
	
	
}
