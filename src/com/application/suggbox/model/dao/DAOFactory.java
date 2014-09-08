package com.application.suggbox.model.dao;

import com.application.suggbox.model.dao.impl.UserDAO;

public class DAOFactory {
	public IUserDAO user() {
		return new UserDAO();
	}
}
