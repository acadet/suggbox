package com.application.suggbox.model.dao;

import java.util.List;

import com.application.suggbox.model.bean.Interest;
import com.application.suggbox.model.bean.Suggestion;
import com.application.suggbox.model.bean.User;

public interface ISuggestionDAO {
	public List<Suggestion> getForUser(User user);
	
	public void add(Suggestion suggestion, User enquirer, List<Interest> interests);
	
	public void delete(Suggestion suggestion);
}
