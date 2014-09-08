package com.application.suggbox.model.dao;

import android.content.Context;

import com.application.suggbox.model.dal.DALFactory;
import com.application.suggbox.model.dao.impl.InterestDAO;
import com.application.suggbox.model.dao.impl.SuggestionDAO;
import com.application.suggbox.model.dao.impl.UserDAO;

public class DAOFactory {
	private DALFactory _dalFactory;
	
	public DAOFactory() {
		this._dalFactory = new DALFactory();
	}
	
	public IUserDAO user(Context context) {
		return new UserDAO(this._dalFactory.dal(context));
	}
	
	public IInterestDAO interest(Context context) {
		return new InterestDAO(this._dalFactory.dal(context));
	}
	
	public ISuggestionDAO suggestion(Context context) {
		return new SuggestionDAO(this._dalFactory.dal(context));
	}
}
