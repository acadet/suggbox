package com.application.suggbox.model.bll;

import java.util.List;

import com.application.suggbox.model.bean.Interest;

public interface IInterestBusiness {
	public List<Interest> sortByNameForUser(String userId);
}
