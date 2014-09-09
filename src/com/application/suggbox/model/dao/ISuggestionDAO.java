package com.application.suggbox.model.dao;

import java.util.List;

import com.application.suggbox.model.bean.Interest;
import com.application.suggbox.model.bean.Suggestion;
import com.application.suggbox.model.bean.User;

/**
 * @class ISuggestionDAO
 * @brief Provides methods to manage storage of suggestions
 */
public interface ISuggestionDAO {
	/**
	 * Sorts suggestions by label for specified user
	 * @param user
	 * @return
	 */
	public List<Suggestion> sortByLabelForUser(User user);
	
	/**
	 * Adds a new suggestion
	 * @param suggestion
	 * @param enquirer
	 * @param interests
	 */
	public void add(Suggestion suggestion, User enquirer, List<Interest> interests);
	
	/**
	 * Deletes provided suggestion
	 * @param suggestion
	 */
	public void delete(Suggestion suggestion);
}
