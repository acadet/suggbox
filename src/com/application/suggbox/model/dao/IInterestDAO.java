package com.application.suggbox.model.dao;

import java.util.List;

import com.application.suggbox.model.bean.Interest;
import com.application.suggbox.model.bean.User;

public interface IInterestDAO {
	public List<Interest> sortByNameForUser(User user);
}
