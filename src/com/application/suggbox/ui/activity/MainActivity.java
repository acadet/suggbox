package com.application.suggbox.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;

import com.application.suggbox.R;
import com.application.suggbox.model.bll.BusinessFactory;
import com.application.suggbox.model.bll.IUserBusiness;
import com.application.suggbox.ui.adapter.UserAdapter;

/**
 * @class MainActivity
 * @brief Main activity. In this view, all users are sorted
 */
public class MainActivity extends Activity {
	private IUserBusiness _userBusiness;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		ListView userList;
		UserAdapter adapter;
		
		this._userBusiness = new BusinessFactory().user(super.getApplicationContext());		
		
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_main);
		
		// Set users
		adapter = new UserAdapter(this, this._userBusiness.sortByName());
		userList = (ListView) super.findViewById(R.id.activity_main_users);
		userList.setAdapter(adapter);
	}
}
