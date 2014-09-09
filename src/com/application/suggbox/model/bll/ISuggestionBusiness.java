package com.application.suggbox.model.bll;

import java.util.List;

import com.application.suggbox.model.bean.Interest;
import com.application.suggbox.model.bean.Suggestion;
import com.application.suggbox.model.bean.User;

public interface ISuggestionBusiness {
	public List<Suggestion> getForUser(User user);
	
	public void add(String label, User user, List<Interest> interests);
	
	public void delete(Suggestion suggestion);
}
