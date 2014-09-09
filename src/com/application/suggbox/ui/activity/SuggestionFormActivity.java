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

public class SuggestionFormActivity extends Activity {
	private IUserBusiness _userBusiness;
	private IInterestBusiness _interestBusiness;
	private ISuggestionBusiness _suggestionBusiness;
	
	private User _currentUser;
	
	private FormSuggestionAdapter _adapter;

	private void _setInterests() {
		Intent intent;
		ListView interestList;
		
		intent = super.getIntent();
		this._currentUser = this._userBusiness.find(intent.getExtras().getString("user-id"));
		
		this._adapter = 
				new FormSuggestionAdapter(
						super.getApplicationContext(),
						this._interestBusiness.sortByNameForUser(this._currentUser)
				);
		interestList = (ListView) super.findViewById(R.id.activity_suggestion_form_interests);
		interestList.setAdapter(this._adapter);
	}
	
	private void _setButton() {
		Button b;
		
		b = (Button) super.findViewById(R.id.activity_suggestion_form_submit);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EditText input;
				List<Interest> selectedInterests;
				Intent intent;
				
				selectedInterests = _adapter.getCheckedInterests();
				
				if (selectedInterests.size() < 1) {
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
					Toast
						.makeText(
								getApplicationContext(),
								"You must provide an idea",
								Toast.LENGTH_SHORT
						)
						.show();
					return;
				}
				
				_suggestionBusiness.add(input.getText().toString(), _currentUser, selectedInterests);
				
				intent = new Intent(getApplicationContext(), UserActivity.class);
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
		super.setContentView(R.layout.activity_suggestion_form);
		
		factory = new BusinessFactory();
		this._userBusiness = factory.user(super.getApplicationContext());
		this._interestBusiness = factory.interest(super.getApplicationContext());
		this._suggestionBusiness = factory.suggestion(super.getApplicationContext());
		
		this._setInterests();
		this._setButton();
	}
}
