package com.application.suggbox.model.bll;

import java.util.List;
import com.application.suggbox.model.bean.User;

public interface IUserBusiness {
	public List<User> sortByName();
	
	public User find(String id);
}
