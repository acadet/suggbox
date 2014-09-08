package com.application.suggbox.model.bll;

import java.util.List;

import com.application.suggbox.model.bean.Suggestion;

public interface ISuggestionBusiness {
	public List<Suggestion> getForUser(String userId);
}
