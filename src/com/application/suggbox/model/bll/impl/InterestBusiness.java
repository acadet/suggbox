package com.application.suggbox.model.bll.impl;

import java.util.List;

import com.application.suggbox.model.bean.Interest;
import com.application.suggbox.model.bll.IInterestBusiness;
import com.application.suggbox.model.dao.IInterestDAO;

public class InterestBusiness implements IInterestBusiness {
	private IInterestDAO _dao;
	
	public InterestBusiness(IInterestDAO dao) {
		this._dao = dao;
	}

	@Override
	public List<Interest> sortByNameForUser(String userId) {
		return this._dao.sortByNameForUser(userId);
	}

}
