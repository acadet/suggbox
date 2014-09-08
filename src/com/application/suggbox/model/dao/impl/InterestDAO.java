package com.application.suggbox.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;

import com.application.suggbox.model.bean.Interest;
import com.application.suggbox.model.dal.IDAL;
import com.application.suggbox.model.dao.IInterestDAO;

public class InterestDAO implements IInterestDAO {
	private IDAL _dal;
	
	public InterestDAO(IDAL dal) {
		this._dal = dal;
	}
	
	@Override
	public List<Interest> sortByNameForUser(String userId) {
		Cursor cursor;
		List<Interest> outcome;
		StringBuffer request;
		
		request = new StringBuffer("SELECT * FROM interest WHERE id IN ");
		request
			.append("(SELECT interest_id FROM user_interest WHERE user_id = ?) ")
			.append("ORDER BY label ASC");
		
		cursor = 
				this._dal.query(
					request.toString(),
					new String[] { userId }
			);
		
		outcome = new ArrayList<Interest>();
		
		while (cursor.moveToNext()) {
			outcome.add(Interest.fromCursor(cursor));
		}
		
		return outcome;
	}
}
