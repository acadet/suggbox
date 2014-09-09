package com.application.suggbox.model.dao;

import android.content.Context;

import com.application.suggbox.model.dal.DALFactory;
import com.application.suggbox.model.dao.impl.InterestDAO;
import com.application.suggbox.model.dao.impl.SuggestionDAO;
import com.application.suggbox.model.dao.impl.UserDAO;

/**
 * @class DAOFactory
 * @brief Builds DAO classes for upper layers
 */
public class DAOFactory {
	/**
	 * DAL factory
	 */
	private DALFactory _dalFactory;
	
	public DAOFactory() {
		this._dalFactory = new DALFactory();
	}
	
	/**
	 * Returns a UserDAO
	 * @param context
	 * @return
	 */
	public IUserDAO user(Context context) {
		return new UserDAO(this._dalFactory.dal(context));
	}
	
	/**
	 * Returns an InterestDAO
	 * @param context
	 * @return
	 */
	public IInterestDAO interest(Context context) {
		return new InterestDAO(this._dalFactory.dal(context));
	}
	
	/**
	 * Returns a SuggestionDAO
	 * @param context
	 * @return
	 */
	public ISuggestionDAO suggestion(Context context) {
		return new SuggestionDAO(this._dalFactory.dal(context));
	}
}
