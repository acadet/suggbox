package com.application.suggbox.model.bean;

import android.database.Cursor;

/**
 * @class Suggestion
 * @brief A suggestion object
 */
public class Suggestion {
	/**
	 * ID of suggestion
	 */
	private String _id;
	
	/**
	 * Label of suggestion
	 */
	private String _label;
	
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
	 * Gets label
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
	 * Creates a suggestion from DB cursor
	 * @param cursor
	 * @return
	 */
	public static Suggestion fromCursor(Cursor cursor) {
		Suggestion s;
		
		s = new Suggestion();
		s.setId(cursor.getString(0));
		s.setLabel(cursor.getString(2));
		
		return s;
	}
}
