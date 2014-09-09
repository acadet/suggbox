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
import com.application.suggbox.ui.util.UserPictureGetter;

/**
 * @class UserActivity
 * @brief User insight. Lists his/her interests and submitted suggestions
 */
public class UserActivity extends Activity {
	/**
	 * User business
	 */
	private IUserBusiness _userBusiness;
	
	/**
	 * Interest business
	 */
	private IInterestBusiness _interestBusiness;
	
	/**
	 * Suggestion business
	 */
	private ISuggestionBusiness _suggestionBusiness;
	
	/**
	 * Current user
	 */
	private User _currentUser;
	
	/**
	 * Fills layout
	 */
	private void _setUser() {
		Intent intent;
		ImageView userPic;
		TextView userName;
		InterestAdapter interestAdapter;
		SimpleSuggestionAdapter suggestionAdapter;
		ListView interestList, suggestionList;
		
		// Current user was stored in intent
		intent = super.getIntent();
		this._currentUser = this._userBusiness.find(intent.getExtras().getString("user-id"));
		
		// Set picture and name
		userPic = (ImageView) super.findViewById(R.id.activity_user_picture);
		userName = (TextView) super.findViewById(R.id.activity_user_name);
		UserPictureGetter.get(this._currentUser, userPic);
		userName.setText(this._currentUser.getFirstName());
		
		// List suggestion
		interestAdapter = new InterestAdapter(
				super.getApplicationContext(),
				this._interestBusiness.sortByLabelForUser(this._currentUser)
		);
		interestList = (ListView) super.findViewById(R.id.activity_user_interests);
		interestList.setAdapter(interestAdapter);
		
		// List existing suggestions
		suggestionAdapter = new SimpleSuggestionAdapter(
				super.getApplicationContext(),
				this._suggestionBusiness.sortByLabelForUser(this._currentUser),
				this._suggestionBusiness
		);
		suggestionList = (ListView) super.findViewById(R.id.activity_user_suggestions);
		suggestionList.setEmptyView(super.findViewById(R.id.activity_user_no_suggestions));
		suggestionList.setAdapter(suggestionAdapter);
	}
	
	/**
	 * Sets up new suggestion button
	 */
	private void _setButton() {
		Button button;
		
		button = (Button) super.findViewById(R.id.activity_user_add_suggestion);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent;
				
				// Move to suggestion form
				intent = new Intent(getApplicationContext(), SuggestionFormActivity.class);
				intent.putExtra("user-id", _currentUser.getId());
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
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
		
		// Collect business classes
		factory = new BusinessFactory();
		this._userBusiness = factory.user(super.getApplicationContext());
		this._interestBusiness = factory.interest(super.getApplicationContext());
		this._suggestionBusiness = factory.suggestion(super.getApplicationContext());
		
		// Set layout
		this._setUser();
		this._setButton();
	}
}
