package com.application.suggbox.model.dal;

import android.database.Cursor;

public interface IDAL {
	public Cursor query(String request, String[] selectionArgs);
}
