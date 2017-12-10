package com.spring.graphql.demo1.model;

public class MPost {
	
	private String uuid;
	private MDate publish;
	private String title;
	private String description;
	private MUser user;
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public MDate getPublish() {
		return publish;
	}
	public void setPublish(MDate publish) {
		this.publish = publish;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public MUser getUser() {
		return user;
	}
	public void setUser(MUser user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "MPost [uuid=" + uuid + ", publish=" + publish + ", title=" + title + ", description=" + description
				+ ", user=" + user + "]";
	}
	
	
}
