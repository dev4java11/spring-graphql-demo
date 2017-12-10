package com.spring.graphql.demo1.model;

public class MUser {

	private String uuid;
	private String fullName;
	private String numberCard;
	private MDate birthday;
	
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
	public MDate getBirthday() {
		return birthday;
	}
	public void setBirthday(MDate birthday) {
		this.birthday = birthday;
	}
	
	@Override
	public String toString() {
		return "MUser [uuid=" + uuid + ", fullName=" + fullName + ", numberCard=" + numberCard + ", birthday="
				+ birthday + "]";
	}
	
	
}
