package com.spring.graphql.demo1.domain;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name = "commentary")
@Entity
public class Commentary implements Domain<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger idCommentary;
	private String uuid;
	private String description;
	private BigInteger idUser;
	private BigInteger idPost;
	@Temporal(TemporalType.TIMESTAMP)
	private Date publish;
	
	public BigInteger getIdCommentary() {
		return idCommentary;
	}
	
	public void setIdCommentary(BigInteger idCommentary) {
		this.idCommentary = idCommentary;
	}

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

	public BigInteger getIdUser() {
		return idUser;
	}

	public void setIdUser(BigInteger idUser) {
		this.idUser = idUser;
	}
	
	public BigInteger getIdPost() {
		return idPost;
	}
	
	public void setIdPost(BigInteger idPost) {
		this.idPost = idPost;
	}
	
	public Date getPublish() {
		return publish;
	}
	
	public void setPublish(Date publish) {
		this.publish = publish;
	}

	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "idUser", referencedColumnName = "idUser", updatable = false, insertable = false, nullable = true)
	private User user;
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	@ManyToOne(targetEntity = Post.class)
	@JoinColumn(name = "idPost", referencedColumnName = "idPost", updatable = false, insertable = false, nullable = true)
	private Post post;
	
	public Post getPost() {
		return post;
	}
	
	public void setPost(Post post) {
		this.post = post;
	}
	
	
	@Override
	public String getId() {
		return getUuid();
	}

	@Override
	public String toString() {
		return "Commentary [idCommentary=" + idCommentary + ", uuid=" + uuid + ", description=" + description
				+ ", idUser=" + idUser + ", idPost=" + idPost + ", publish=" + publish + ", user=" + user + ", post="
				+ post + "]";
	}
	
	
	
}
