package com.application.suggbox.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
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
import com.application.suggbox.ui.adapter.SimpleSuggestionAdapter;

public class UserActivity extends Activity {
	private IUserBusiness _userBusiness;
	private IInterestBusiness _interestBusiness;
	private ISuggestionBusiness _suggestionBusiness;
	
	private User _currentUser;
	
	private void _setUser() {
		Intent intent;
		ImageView userPic;
		TextView userName;
		InterestAdapter interestAdapter;
		SimpleSuggestionAdapter suggestionAdapter;
		ListView interestList, suggestionList;
		
		intent = super.getIntent();
		this._currentUser = this._userBusiness.find(intent.getExtras().getString("user-id"));
		
		userPic = (ImageView) super.findViewById(R.id.activity_user_picture);
		userName = (TextView) super.findViewById(R.id.activity_user_name);
		userPic.setImageResource(R.drawable.default_user);
		userName.setText(this._currentUser.getFirstName());
		
		interestAdapter = new InterestAdapter(
				super.getApplicationContext(),
				this._interestBusiness.sortByNameForUser(this._currentUser.getId())
		);
		interestList = (ListView) super.findViewById(R.id.activity_user_interests);
		interestList.setAdapter(interestAdapter);
		
		suggestionAdapter = new SimpleSuggestionAdapter(
				super.getApplicationContext(),
				this._suggestionBusiness.getForUser(this._currentUser.getId())
		);
		suggestionList = (ListView) super.findViewById(R.id.activity_user_suggestions);
		suggestionList.setEmptyView(super.findViewById(R.id.activity_user_no_suggestions));
		suggestionList.setAdapter(suggestionAdapter);
	}
	
	private void _setButton() {
		Button button;
		
		button = (Button) super.findViewById(R.id.activity_user_add_suggestion);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent;
				
				intent = new Intent(getApplicationContext(), SuggestionFormActivity.class);
				intent.putExtra("user-id", _currentUser.getId());
				getApplicationContext().startActivity(intent);
			}
		});
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
		this._setButton();
	}
}
