package com.application.suggbox.model.dal;

import android.content.ContentValues;
import android.database.Cursor;

public interface IDAL {
	public void insert(String table, ContentValues values);
	
	public void delete(String table, String whereClause, String[] whereArgs);
	
	public Cursor query(String request, String[] selectionArgs);
}
