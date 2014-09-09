package com.application.suggbox.model.bll;

import java.util.List;
import com.application.suggbox.model.bean.User;

/**
 * @class IUserBusiness
 * @brief Provides methods to manage users
 */
public interface IUserBusiness {
	/**
	 * Sorts users by name
	 * @return
	 */
	public List<User> sortByName();
	
	/**
	 * Finds a user using provided id
	 * @param id
	 * @return
	 */
	public User find(String id);
}
