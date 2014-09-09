package com.application.suggbox.model.bean;

import android.database.Cursor;

import com.application.suggbox.model.bean.util.UserPicture;

/**
 * @class User
 * @brief A user object
 */
public class User {
	/**
	 * ID of user
	 */
	private String _id;
	
	/**
	 * First name of user
	 */
	private String _firstName;
	
	/**
	 * Id of picture
	 */
	private UserPicture _picture;
	
	/**
	 * Gets id
	 * @return
	 */
	public String getId() {
		return this._id;
	}
	
	/**
	 * Sets id
	 * @param value
	 */
	public void setId(String value) {
		this._id = value;
	}
	
	/**
	 * Gets first name
	 * @return
	 */
	public String getFirstName() {
		return this._firstName;
	}
	
	/**
	 * Sets first name
	 */
	public void setFirstName(String value) {
		this._firstName = value;
	}
	
	/**
	 * Gets picture
	 * @return
	 */
	public UserPicture getPicture() {
		return this._picture;
	}
	
	/**
	 * Sets picture using int value
	 * @param value
	 */
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
	
	/**
	 * Sets picture
	 * @param value
	 */
	public void setPicture(UserPicture value) {
		this._picture = value;
	}
	
	/**
	 * Creates a user from DB cursor
	 * @param cursor
	 * @return
	 */
	public static User fromCursor(Cursor cursor) {
		User u;
		
		u = new User();
		u.setId(cursor.getString(0));
		u.setFirstName(cursor.getString(1));
		u.setPicture(cursor.getInt(2));
		
		return u;
	}
}
