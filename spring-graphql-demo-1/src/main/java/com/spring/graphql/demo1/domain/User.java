package com.spring.graphql.demo1.domain;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name = "user")
@Entity
public class User implements Domain<String>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger idUser;
	private String uuid;
	private String fullName;
	private String numberCard;
	@Temporal(TemporalType.DATE)
	private Date birthday;
	
	public BigInteger getIdUser() {
		return idUser;
	}
	
	public void setIdUser(BigInteger idUser) {
		this.idUser = idUser;
	}
	
	public String getUuid() {
		return uuid;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getNumberCard() {
		return numberCard;
	}

	public void setNumberCard(String numberCard) {
		this.numberCard = numberCard;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	@Override
	public String getId() {
		return getUuid();
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", uuid=" + uuid + ", fullName=" + fullName + ", numberCard=" + numberCard
				+ ", birthday=" + birthday + "]";
	}
}
