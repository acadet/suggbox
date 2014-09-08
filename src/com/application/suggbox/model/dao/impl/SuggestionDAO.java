package com.application.suggbox.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;

import com.application.suggbox.model.bean.Suggestion;
import com.application.suggbox.model.dal.IDAL;
import com.application.suggbox.model.dao.ISuggestionDAO;

public class SuggestionDAO implements ISuggestionDAO {
	private IDAL _dal;
	
	public SuggestionDAO(IDAL dal) {
		this._dal = dal;
	}	
	
	@Override
	public List<Suggestion> getForUser(String userId) {
		Cursor cursor;
		List<Suggestion> outcome;
		
		cursor = this._dal.query(
				"SELECT * FROM suggestion WHERE enquirer_id = ?",
				new String[] { userId }
		);
				
		outcome = new ArrayList<Suggestion>();
		
		while (cursor.moveToNext()) {
			outcome.add(Suggestion.fromCursor(cursor));
		}
		
		return outcome;
	}
}
