package com.application.suggbox.model.bll;

import java.util.List;

import com.application.suggbox.model.bean.Interest;
import com.application.suggbox.model.bean.Suggestion;
import com.application.suggbox.model.bean.User;

/**
 * @class ISuggestionBusiness
 * @brief Provides methods to manage suggestions
 */
public interface ISuggestionBusiness {
	/**
	 * Sorts suggestions by label for a specified user
	 * @param user
	 * @return
	 */
	public List<Suggestion> sortByLabelForUser(User user);
	
	/**
	 * Adds a new suggestion
	 * @param label Label to use
	 * @param user Enquirer
	 * @param interests Matching interests
	 */
	public void add(String label, User user, List<Interest> interests);
	
	/**
	 * Deletes existing suggestion
	 * @param suggestion
	 */
	public void delete(Suggestion suggestion);
}
