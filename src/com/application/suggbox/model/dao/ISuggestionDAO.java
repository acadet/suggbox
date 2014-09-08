package com.application.suggbox.model.dao;

import java.util.List;

import com.application.suggbox.model.bean.Suggestion;

public interface ISuggestionDAO {
	public List<Suggestion> getForUser(String userId);
}
