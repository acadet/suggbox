package com.application.suggbox.model.bll;

import java.util.List;

import com.application.suggbox.model.bean.Interest;
import com.application.suggbox.model.bean.User;

public interface IInterestBusiness {
	public List<Interest> sortByNameForUser(User user);
}
