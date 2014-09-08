package com.application.suggbox.model.dao.impl;

import java.util.List;

import android.database.Cursor;

import com.application.suggbox.model.bean.User;
import com.application.suggbox.model.dal.IDAL;
import com.application.suggbox.model.dao.IUserDAO;

public class UserDAO implements IUserDAO {
	private IDAL _dal;
	
	public UserDAO(IDAL dal) {
		this._dal = dal;
	}

	@Override
	public List<User> sortByName() {
		Cursor cursor;
		
		cursor = this._dal.query(
				"SELECT * FROM user ORDER BY firstName ASC",
				null
		);
		
		return null;
	}
}
