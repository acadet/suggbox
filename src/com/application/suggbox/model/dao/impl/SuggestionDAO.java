package com.application.suggbox.model.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import android.content.ContentValues;
import android.database.Cursor;

import com.application.suggbox.model.bean.Interest;
import com.application.suggbox.model.bean.Suggestion;
import com.application.suggbox.model.bean.User;
import com.application.suggbox.model.dal.IDAL;
import com.application.suggbox.model.dao.ISuggestionDAO;

public class SuggestionDAO implements ISuggestionDAO {
	private IDAL _dal;
	
	public SuggestionDAO(IDAL dal) {
		this._dal = dal;
	}	
	
	@Override
	public List<Suggestion> getForUser(User user) {
		Cursor cursor;
		List<Suggestion> outcome;
		
		cursor = this._dal.query(
				"SELECT * FROM suggestion WHERE enquirer_id = ?",
				new String[] { user.getId() }
		);
				
		outcome = new ArrayList<Suggestion>();
		
		while (cursor.moveToNext()) {
			outcome.add(Suggestion.fromCursor(cursor));
		}
		
		return outcome;
	}

	@Override
	public void add(Suggestion suggestion, User enquirer, List<Interest> interests) {
		ContentValues s;
		String id;
		
		s = new ContentValues();
		id = UUID.randomUUID().toString();
		s.put("id", id);
		s.put("label", suggestion.getLabel());
		s.put("enquirer_id", enquirer.getId());
		
		this._dal.insert("suggestion", s);
		
		for (Interest i : interests) {
			ContentValues relation;
			
			relation = new ContentValues();
			relation.put("suggestion_id", id);
			relation.put("interest_id", i.getId());
			this._dal.insert("suggestion_interest", relation);
		}
	}
	
	@Override
	public void delete(Suggestion suggestion) {
		this._dal.delete(
				"suggestion_interest",
				"suggestion_id = ?",
				new String[] { suggestion.getId()}
		);
		this._dal.delete(
				"suggestion",
				"id = ? ",
				new String[] { suggestion.getId() }
		);
	}
}
