package com.application.suggbox.model.dal;

import android.content.Context;

import com.application.suggbox.model.dal.impl.SQLDAL;

/**
 * @class DALFactory
 * @brief Build DAL class for upper layers
 */
public class DALFactory {
	/**
	 * Builds current used DAL
	 * @param context
	 * @return
	 */
	public IDAL dal(Context context) {
		return new SQLDAL(context);
	}
}
