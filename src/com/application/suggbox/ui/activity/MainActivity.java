package com.application.suggbox.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

import com.application.suggbox.R;
import com.application.suggbox.model.bll.BusinessFactory;
import com.application.suggbox.model.bll.IUserBusiness;
import com.application.suggbox.ui.adaptator.UserAdaptator;

public class MainActivity extends Activity {
	private IUserBusiness _userBusiness;
	
	public MainActivity() {
		this._userBusiness = new BusinessFactory().user();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		ListView userList;
		UserAdaptator adaptator;
		
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_main);
		
		adaptator = new UserAdaptator(this, this._userBusiness.sortByName());
		userList = (ListView) super.findViewById(R.layout.user_insight);
		userList.setAdapter(adaptator);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		super.getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
