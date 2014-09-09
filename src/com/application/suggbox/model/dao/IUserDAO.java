package com.application.suggbox.model.dao;

import java.util.List;

import com.application.suggbox.model.bean.User;

/**
 * @class IUserDAO
 * @brief Provides methods to manage storage of users
 */
public interface IUserDAO {
	/**
	 * Sorts users by name
	 * @return
	 */
	public List<User> sortByName();
	
	/**
	 * Finds user using its id
	 * @param id
	 * @return
	 */
	public User find(String id);
}
