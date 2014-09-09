package com.application.suggbox.model.bean;

import android.database.Cursor;

/**
 * @class Interest
 * @brief Represents an interest object
 */
public class Interest {
	/**
	 * If of interest
	 */
	private String _id;
	
	/**
	 * Label of interest
	 */
	private String _label;
	
	/**
	 * Returns id
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
	 * Returns label
	 * @return
	 */
	public String getLabel() {
		return this._label;
	}
	
	/**
	 * Sets label
	 * @param value
	 */
	public void setLabel(String value) {
		this._label = value;
	}
	
	/**
	 * Creates an interest from a DB cursor
	 * @param cursor
	 * @return
	 */
	public static Interest fromCursor(Cursor cursor) {
		Interest i;
		
		i = new Interest();
		i.setId(cursor.getString(0));
		i.setLabel(cursor.getString(1));
		
		return i;
	}
}
