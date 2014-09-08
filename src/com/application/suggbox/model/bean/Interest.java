package com.application.suggbox.model.bean;

import android.database.Cursor;

public class Interest {
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
	
	public static Interest fromCursor(Cursor cursor) {
		Interest i;
		
		i = new Interest();
		i.setId(cursor.getString(0));
		i.setLabel(cursor.getString(1));
		
		return i;
	}
}
