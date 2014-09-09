package com.application.suggbox.model.bll.impl;

import java.util.List;

import com.application.suggbox.model.bean.Interest;
import com.application.suggbox.model.bean.User;
import com.application.suggbox.model.bll.IInterestBusiness;
import com.application.suggbox.model.dao.IInterestDAO;

/**
 * @class InterestBusiness
 * @brief An implementation of InterestBusiness
 */
public class InterestBusiness implements IInterestBusiness {
	private IInterestDAO _dao;
	
	public InterestBusiness(IInterestDAO dao) {
		this._dao = dao;
	}

	@Override
	public List<Interest> sortByLabelForUser(User user) {
		return this._dao.sortByLabelForUser(user);
	}
}
