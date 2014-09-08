package com.application.suggbox.model.bll;

import android.content.Context;

import com.application.suggbox.model.bll.impl.InterestBusiness;
import com.application.suggbox.model.bll.impl.SuggestionBusiness;
import com.application.suggbox.model.bll.impl.UserBusiness;
import com.application.suggbox.model.dao.DAOFactory;

public class BusinessFactory {
	private DAOFactory _daoFactory;
	
	public BusinessFactory() {
		this._daoFactory = new DAOFactory();
	}

	public IUserBusiness user(Context context) {
		return new UserBusiness(this._daoFactory.user(context));
	}
	
	public IInterestBusiness interest(Context context) {
		return new InterestBusiness(this._daoFactory.interest(context));
	}
	
	public ISuggestionBusiness suggestion(Context context) {
		return new SuggestionBusiness(this._daoFactory.suggestion(context));
	}
}
