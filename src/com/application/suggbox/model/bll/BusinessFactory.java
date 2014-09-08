package com.application.suggbox.model.bll;

import com.application.suggbox.model.bll.impl.UserBusiness;
import com.application.suggbox.model.dao.DAOFactory;

public class BusinessFactory {
	private DAOFactory _daoFactory;
	
	public BusinessFactory() {
		this._daoFactory = new DAOFactory();
	}

	public IUserBusiness user() {
		return new UserBusiness(this._daoFactory.user());
	}
}
