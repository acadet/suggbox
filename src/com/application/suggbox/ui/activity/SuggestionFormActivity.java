package com.application.suggbox.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;

import com.application.suggbox.R;
import com.application.suggbox.model.bean.User;
import com.application.suggbox.model.bll.BusinessFactory;
import com.application.suggbox.model.bll.IInterestBusiness;
import com.application.suggbox.model.bll.IUserBusiness;
import com.application.suggbox.ui.adapter.FormSuggestionAdapter;

public class SuggestionFormActivity extends Activity {
	private IUserBusiness _userBusiness;
	private IInterestBusiness _interestBusiness;
	private User _currentUser;

	private void _setInterests() {
		Intent intent;
		FormSuggestionAdapter adapter;
		ListView interestList;
		
		intent = super.getIntent();
		this._currentUser = this._userBusiness.find(intent.getExtras().getString("user-id"));
		
		adapter = 
				new FormSuggestionAdapter(
						super.getApplicationContext(),
						this._interestBusiness.sortByNameForUser(this._currentUser.getId())
				);
		interestList = (ListView) super.findViewById(R.id.activity_suggestion_form_interests);
		interestList.setAdapter(adapter);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		BusinessFactory factory;
		
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_suggestion_form);
		
		factory = new BusinessFactory();
		this._userBusiness = factory.user(super.getApplicationContext());
		this._interestBusiness = factory.interest(super.getApplicationContext());
		
		this._setInterests();
	}
}
