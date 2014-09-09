package com.application.suggbox.model.dao;

import java.util.List;

import com.application.suggbox.model.bean.Interest;
import com.application.suggbox.model.bean.User;

/**
 * @class IInterestDAO
 * @brief Provides methods to manage storage of interests
 */
public interface IInterestDAO {
	/**
	 * Sorts interests by label for a specified user
	 * @param user
	 * @return
	 */
	public List<Interest> sortByLabelForUser(User user);
}
