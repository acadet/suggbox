package com.application.suggbox.model.bean;

import android.database.Cursor;

import com.application.suggbox.model.bean.util.UserPicture;

public class User {
	private String _id;
	
	private String _firstName;
	
	private UserPicture _picture;
	
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
	
	public UserPicture getPicture() {
		return this._picture;
	}
	
	public void setPicture(int value) {
		switch(value) {
		case 1:
			this._picture = UserPicture.Ben;
			break;
		case 2:
			this._picture = UserPicture.Clement;
			break;
		case 3:
			this._picture = UserPicture.Pierre;
			break;
		default:
			this._picture = UserPicture.Default;
			break;
		}
	}
	
	public void setPicture(UserPicture value) {
		this._picture = value;
	}
	
	public static User fromCursor(Cursor cursor) {
		User u;
		
		u = new User();
		u.setId(cursor.getString(0));
		u.setFirstName(cursor.getString(1));
		u.setPicture(cursor.getInt(2));
		
		return u;
	}
}
