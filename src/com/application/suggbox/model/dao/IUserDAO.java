package com.application.suggbox.model.dao;

import java.util.List;

import com.application.suggbox.model.bean.User;

public interface IUserDAO {
	public List<User> sortByName();
	
	public User find(String id);
}
