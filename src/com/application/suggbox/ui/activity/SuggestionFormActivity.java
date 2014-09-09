package com.application.suggbox.ui.activity;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.application.suggbox.R;
import com.application.suggbox.model.bean.Interest;
import com.application.suggbox.model.bean.User;
import com.application.suggbox.model.bll.BusinessFactory;
import com.application.suggbox.model.bll.IInterestBusiness;
import com.application.suggbox.model.bll.ISuggestionBusiness;
import com.application.suggbox.model.bll.IUserBusiness;
import com.application.suggbox.ui.adapter.FormSuggestionAdapter;

/**
 * @class SuggestionFormActivity
 * @brief Manages suggestion form.
 */
public class SuggestionFormActivity extends Activity {
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
	 * Current form suggestion adapter
	 */
	private FormSuggestionAdapter _adapter;

	/**
	 * Lists all interests
	 */
	private void _setInterests() {
		Intent intent;
		ListView interestList;
		
		// Current user was stored in intent
		intent = super.getIntent();
		this._currentUser = this._userBusiness.find(intent.getExtras().getString("user-id"));
		
		this._adapter = 
				new FormSuggestionAdapter(
						super.getApplicationContext(),
						this._interestBusiness.sortByLabelForUser(this._currentUser)
				);
		interestList = (ListView) super.findViewById(R.id.activity_suggestion_form_interests);
		interestList.setAdapter(this._adapter);
	}
	
	/**
	 * Sets up submit button
	 */
	private void _setButton() {
		Button b;
		
		b = (Button) super.findViewById(R.id.activity_suggestion_form_submit);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EditText input;
				List<Interest> selectedInterests;
				
				// Start of submit process
				// Get selected interests
				selectedInterests = _adapter.getCheckedInterests();
				
				if (selectedInterests.size() < 1) {
					// No checked interests
					Toast
						.makeText(
								getApplicationContext(),
								"You must select at least one interest", 
								Toast.LENGTH_SHORT
						)
						.show();
					return;
				}
				
				input = (EditText) findViewById(R.id.activity_suggestion_form_input);
				if (input.getText().toString().trim().length() == 0) {
					// No idea suggested
					Toast
						.makeText(
								getApplicationContext(),
								"You must provide an idea",
								Toast.LENGTH_SHORT
						)
						.show();
					return;
				}
				
				// Create suggestion
				_suggestionBusiness.add(input.getText().toString(), _currentUser, selectedInterests);
				
				// Move back to user insight
				finish();
			}
		});
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		BusinessFactory factory;
		
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_suggestion_form);
		
		// Collect business classes
		factory = new BusinessFactory();
		this._userBusiness = factory.user(super.getApplicationContext());
		this._interestBusiness = factory.interest(super.getApplicationContext());
		this._suggestionBusiness = factory.suggestion(super.getApplicationContext());
		
		// Set layout
		this._setInterests();
		this._setButton();
	}
}
