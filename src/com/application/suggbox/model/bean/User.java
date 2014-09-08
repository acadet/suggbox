package com.application.suggbox.model.bean;

public class User {
	private String _id;
	
	private String _firstName;
	
	private String _picture;
	
	public String getId() {
		return this._id;
	}
	
	public void setId(String value) {
		this._id = value;
	}
	
	public String getFirstName() {
		return this._firstName;
	}
	
	public void setFirstName(String value) {
		this._firstName = value;
	}
	
	public String getPicture() {
		return this._picture;
	}
	
	public void setPicture(String value) {
		this._picture = value;
	}
}
