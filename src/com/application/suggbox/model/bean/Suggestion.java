package com.application.suggbox.model.bean;

import android.database.Cursor;

public class Suggestion {
	private String _id;
	private String _label;
	
	public String getId() {
		return this._id;
	}
	
	public void setId(String value) {
		this._id = value;
	}
	
	public String getLabel() {
		return this._label;
	}
	
	public void setLabel(String value) {
		this._label = value;
	}
	
	public static Suggestion fromCursor(Cursor cursor) {
		Suggestion s;
		
		s = new Suggestion();
		s.setId(cursor.getString(0));
		s.setLabel(cursor.getString(2));
		
		return s;
	}
}
