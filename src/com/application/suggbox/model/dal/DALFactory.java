package com.application.suggbox.model.dal;

import android.content.Context;

import com.application.suggbox.model.dal.impl.SQLDAL;

public class DALFactory {
	public IDAL dal(Context context) {
		return new SQLDAL(context);
	}
}
