package com.application.suggbox.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.application.suggbox.R;
import com.application.suggbox.model.bean.User;
import com.application.suggbox.model.bll.BusinessFactory;
import com.application.suggbox.model.bll.IInterestBusiness;
import com.application.suggbox.model.bll.ISuggestionBusiness;
import com.application.suggbox.model.bll.IUserBusiness;
import com.application.suggbox.ui.adapter.InterestAdapter;
import com.application.suggbox.ui.adapter.SuggestionAdapter;

public class UserActivity extends Activity {
	private IUserBusiness _userBusiness;
	private IInterestBusiness _interestBusiness;
	private ISuggestionBusiness _suggestionBusiness;
	
	private void _setUser() {
		Intent intent;
		User user;
		ImageView userPic;
		TextView userName;
		InterestAdapter interestAdapter;
		SuggestionAdapter suggestionAdapter;
		ListView interestList, suggestionList;
		
		intent = super.getIntent();
		user = this._userBusiness.find(intent.getExtras().getString("user-id"));
		
		userPic = (ImageView) super.findViewById(R.id.activity_user_picture);
		userName = (TextView) super.findViewById(R.id.activity_user_name);
		userPic.setImageResource(R.drawable.default_user);
		userName.setText(user.getFirstName());
		
		interestAdapter = new InterestAdapter(
				super.getApplicationContext(),
				this._interestBusiness.sortByNameForUser(user.getId())
		);
		interestList = (ListView) super.findViewById(R.id.activity_user_interests);
		interestList.setAdapter(interestAdapter);
		
		suggestionAdapter = new SuggestionAdapter(
				super.getApplicationContext(),
				this._suggestionBusiness.getForUser(user.getId())
		);
		suggestionList = (ListView) super.findViewById(R.id.activity_user_suggestions);
		suggestionList.setEmptyView(super.findViewById(R.id.activity_user_no_suggestions));
		suggestionList.setAdapter(suggestionAdapter);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		BusinessFactory factory;
		
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_user);
		
		factory = new BusinessFactory();
		this._userBusiness = factory.user(super.getApplicationContext());
		this._interestBusiness = factory.interest(super.getApplicationContext());
		this._suggestionBusiness = factory.suggestion(super.getApplicationContext());
		
		this._setUser();
	}
}
