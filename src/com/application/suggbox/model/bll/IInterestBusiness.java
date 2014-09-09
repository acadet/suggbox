package com.application.suggbox.model.bll;

import java.util.List;

import com.application.suggbox.model.bean.Interest;
import com.application.suggbox.model.bean.User;

/**
 * @class IInterestBusiness
 * @brief Provides methods to manage interests
 */
public interface IInterestBusiness {
	/**
	 * Sorts interests by label for a specified user 
	 * @param user
	 * @return
	 */
	public List<Interest> sortByLabelForUser(User user);
}
