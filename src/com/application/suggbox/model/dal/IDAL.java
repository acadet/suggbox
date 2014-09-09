package com.application.suggbox.model.dal;

import android.content.ContentValues;
import android.database.Cursor;

/**
 * @class IDAL
 * @brief Provides methods to manage storage device
 */
public interface IDAL {
	/**
	 * Inserts entry
	 * @param table Targeted table
	 * @param values Values to add
	 */
	public void insert(String table, ContentValues values);
	
	/**
	 * Deletes entries from specified table 
	 * @param table Targeted table
	 * @param whereClause Clause to filter data
	 * @param whereArgs Args to replace
	 */
	public void delete(String table, String whereClause, String[] whereArgs);
	
	/**
	 * Executes a SELECT request
	 * @param request
	 * @param selectionArgs
	 * @return
	 */
	public Cursor query(String request, String[] selectionArgs);
}
