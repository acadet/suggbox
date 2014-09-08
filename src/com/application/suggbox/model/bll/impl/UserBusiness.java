package com.application.suggbox.model.bll.impl;

import java.util.List;

import com.application.suggbox.model.bean.User;
import com.application.suggbox.model.bll.IUserBusiness;
import com.application.suggbox.model.dao.IUserDAO;

public class UserBusiness implements IUserBusiness {
	private IUserDAO _userDAO;
	
	public UserBusiness(IUserDAO userDAO) {
		this._userDAO = userDAO;
	}

	@Override
	public List<User> sortByName() {
		return this._userDAO.sortByName();
	}

	@Override
	public User find(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
