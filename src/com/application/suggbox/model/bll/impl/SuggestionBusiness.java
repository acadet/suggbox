package com.application.suggbox.model.bll.impl;

import java.util.List;

import com.application.suggbox.model.bean.Interest;
import com.application.suggbox.model.bean.Suggestion;
import com.application.suggbox.model.bean.User;
import com.application.suggbox.model.bll.ISuggestionBusiness;
import com.application.suggbox.model.dao.ISuggestionDAO;

/**
 * @class SuggestionBusiness
 * @brief An implementation of ISuggestionBusiness
 */
public class SuggestionBusiness implements ISuggestionBusiness {
	private ISuggestionDAO _dao;
	
	public SuggestionBusiness(ISuggestionDAO dao) {
		this._dao = dao;
	}

	@Override
	public List<Suggestion> sortByLabelForUser(User user) {
		return this._dao.sortByLabelForUser(user);
	}
	
	@Override
	public void add(String label, User user, List<Interest> interests) {
		Suggestion s;
		
		s = new Suggestion();
		s.setLabel(label);
		this._dao.add(s, user, interests);
	}
	
	@Override
	public void delete(Suggestion suggestion) {
		this._dao.delete(suggestion);
	}
}
