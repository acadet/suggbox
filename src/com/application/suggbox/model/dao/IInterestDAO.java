package com.application.suggbox.model.dao;

import java.util.List;

import com.application.suggbox.model.bean.Interest;

public interface IInterestDAO {
	public List<Interest> sortByNameForUser(String userId);
}
