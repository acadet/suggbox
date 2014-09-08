package com.application.suggbox.model.bll.impl;

import java.util.List;

import com.application.suggbox.model.bean.Suggestion;
import com.application.suggbox.model.bll.ISuggestionBusiness;
import com.application.suggbox.model.dao.ISuggestionDAO;

public class SuggestionBusiness implements ISuggestionBusiness {
	private ISuggestionDAO _dao;
	
	public SuggestionBusiness(ISuggestionDAO dao) {
		this._dao = dao;
	}

	@Override
	public List<Suggestion> getForUser(String userId) {
		return this._dao.getForUser(userId);
	}
}
