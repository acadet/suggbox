package com.application.suggbox.model.dal.impl;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.application.suggbox.model.dal.IDAL;

public class SQLDAL extends SQLiteOpenHelper implements IDAL {
	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "SuggBox.db";
	
	public SQLDAL(Context context) {
		super(context, SQLDAL.DATABASE_NAME, null, SQLDAL.DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		StringBuffer request;
		
		// User table
		request = new StringBuffer("CREATE TABLE user IF NOT EXISTS (");
		request
			.append("id TEXT PRIMARY KEY, ")
			.append("firstName TEXT, ")
			.append("picture TEXT);");
		database.execSQL(request.toString());
		
		// Interest table
		request = new StringBuffer("CREATE TABLE interest IF NOT EXISTS (");
		request
			.append("id TEXT PRIMARY KEY, ")
			.append("label TEXT);");
		database.execSQL(request.toString());
		
		// User/interest relationship
		request = new StringBuffer("CREATE TABLE user_interest IF NOT EXISTS (");
		request
			.append("user_id TEXT, ")
			.append("interest_id TEXT, ")
			.append("PRIMARY KEY (user_id, interest_id), ")
			.append("FOREIGN KEY(user_id) REFERENCES user(id), ")
			.append("FOREIGN KEY(interest_id) REFERENCES interest(id));");
		database.execSQL(request.toString());
		
		// Suggestion table
		request = new StringBuffer("CREATE TABLE suggestion IF NOT EXISTS (");
		request
			.append("id TEXT PRIMARY KEY, ")
			.append("enquirer_id TEXT, ")
			.append("label TEXT, ")
			.append("FOREIGN KEY(enquirer_id) REFERENCES user(id));");
		database.execSQL(request.toString());
		
		// Suggestion/interest table
		request = new StringBuffer("CREATE TABLE suggestion_interest IF NOT EXISTS (");
		request
			.append("suggestion_id TEXT, ")
			.append("interest_id TEXT, ")
			.append("PRIMARY KEY(suggestion_id, interest_id), ")
			.append("FOREIGN KEY(suggestion_id) REFERENCES suggestion(id), ")
			.append("FOREIGN KEY(interest_id) REFERENCES interest(id));");
		database.execSQL(request.toString());
		
		// Fill user table
		database.execSQL(
				"INSERT OR IGNORE INTO user (id, firstName, picture) VALUES ('1', 'Clement', 'clement.png');"
		);
		database.execSQL(
				"INSERT OR IGNORE INTO user (id, firstName, picture) VALUES ('2', 'Pierre', 'pierre.png');"
		);
		database.execSQL(
				"INSERT OR IGNORE INTO user (id, firstName, picture) VALUES ('3', 'Ben', 'ben.png');"
		);
		
		// Fill interest table
		database.execSQL(
				"INSERT OR IGNORE INTO interest (id, label) VALUES ('1', 'Sports');"
		);
		database.execSQL(
				"INSERT OR IGNORE INTO interest (id, label) VALUES ('2', 'Web design');"
		);
		database.execSQL(
				"INSERT OR IGNORE INTO interest (id, label) VALUES ('3', 'Cooking');"
		);
		database.execSQL(
				"INSERT OR IGNORE INTO interest (id, label) VALUES ('4', 'Movies');"
		);
		database.execSQL(
				"INSERT OR IGNORE INTO interest (id, label) VALUES ('5', 'Reading');"
		);
		
		// Fill user/interest relationship
		database.execSQL(
				"INSERT OR IGNORE INTO user_interest (user_id, interest_id) VALUES ('1', '2');"
		);
		database.execSQL(
				"INSERT OR IGNORE INTO user_interest (user_id, interest_id) VALUES ('1', '3');"
		);
		database.execSQL(
				"INSERT OR IGNORE INTO user_interest (user_id, interest_id) VALUES ('1', '4');"
		);
		
		database.execSQL(
				"INSERT OR IGNORE INTO user_interest (user_id, interest_id) VALUES ('2', '1');"
		);
		database.execSQL(
				"INSERT OR IGNORE INTO user_interest (user_id, interest_id) VALUES ('2', '4');"
		);
		
		database.execSQL(
				"INSERT OR IGNORE INTO user_interest (user_id, interest_id) VALUES ('3', '2');"
		);
		database.execSQL(
				"INSERT OR IGNORE INTO user_interest (user_id, interest_id) VALUES ('3', '4');"
		);
		database.execSQL(
				"INSERT OR IGNORE INTO user_interest (user_id, interest_id) VALUES ('3', '5');"
		);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
	}
	
	/*public void insert(String table, ContentValues values) {
		super.getWritableDatabase().insert(table, null, values);
	}*/
	
	public Cursor query(String request, String[] selectionArgs) {
		return super.getReadableDatabase().rawQuery(request, selectionArgs);
	}
}
