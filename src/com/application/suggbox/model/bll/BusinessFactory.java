package com.application.suggbox.model.bll;

import android.content.Context;

import com.application.suggbox.model.bll.impl.InterestBusiness;
import com.application.suggbox.model.bll.impl.SuggestionBusiness;
import com.application.suggbox.model.bll.impl.UserBusiness;
import com.application.suggbox.model.dao.DAOFactory;

/**
 * @class BusinessFactory
 * @brief Creates business objects for upper layers
 */
public class BusinessFactory {
	/**
	 * DAO factory
	 */
	private DAOFactory _daoFactory;
	
	public BusinessFactory() {
		this._daoFactory = new DAOFactory();
	}

	/**
	 * Returns a user business
	 * @param context
	 * @return
	 */
	public IUserBusiness user(Context context) {
		return new UserBusiness(this._daoFactory.user(context));
	}
	
	/**
	 * Returns an interest business
	 * @param context
	 * @return
	 */
	public IInterestBusiness interest(Context context) {
		return new InterestBusiness(this._daoFactory.interest(context));
	}
	
	/**
	 * Represents a suggestion business
	 * @param context
	 * @return
	 */
	public ISuggestionBusiness suggestion(Context context) {
		return new SuggestionBusiness(this._daoFactory.suggestion(context));
	}
}
