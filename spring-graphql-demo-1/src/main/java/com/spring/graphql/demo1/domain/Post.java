package com.spring.graphql.demo1.domain;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name = "post")
@Entity
public class Post implements Domain<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger idPost;
	private String uuid;
	@Temporal(TemporalType.TIMESTAMP)
	private Date publish;
	private String title;
	private String description;
	private BigInteger idUser;
	
	
	public BigInteger getIdPost() {
		return idPost;
	}
	public void setIdPost(BigInteger idPost) {
		this.idPost = idPost;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public Date getPublish() {
		return publish;
	}
	public void setPublish(Date publish) {
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
	public BigInteger getIdUser() {
		return idUser;
	}
	public void setIdUser(BigInteger idUser) {
		this.idUser = idUser;
	}
	
	@OneToOne
	@JoinColumn(name = "idUser", referencedColumnName = "idUser", updatable = false, insertable = false, nullable = true)
	private User user;
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String getId() {
		return getUuid();
	}
	
	
	@Override
	public String toString() {
		return "Post [idPost=" + idPost + ", uuid=" + uuid + ", publish=" + publish + ", title=" + title
				+ ", description=" + description + ", idUser=" + idUser + ", user=" + user + "]";
	}
	
	
}
