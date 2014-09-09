package com.application.suggbox.ui.adapter;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.application.suggbox.R;
import com.application.suggbox.model.bean.User;
import com.application.suggbox.ui.activity.UserActivity;
import com.application.suggbox.ui.util.UserPictureGetter;

/**
 * @class UserAdapter
 * @brief Adapts users for main view
 */
public class UserAdapter extends BaseAdapter {
	/**
	 * Current users
	 */
	private List<User> _users;
	
	/**
	 * Current context
	 */
	private Context _context;
	
	/**
	 * Current inflater
	 */
	private LayoutInflater _inflater;
	
	public UserAdapter(Context context, List<User> users) {
		this._context = context;
		this._users = users;
		this._inflater = LayoutInflater.from(this._context);
	}

	@Override
	public int getCount() {
		return this._users.size();
	}

	@Override
	public Object getItem(int arg0) {
		return this._users.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int position, View itemView, ViewGroup parentView) {
		LinearLayout insight;
		ImageView pic;
		TextView name;
		User u;
		
		if (itemView == null) {
			insight = (LinearLayout) this._inflater.inflate(R.layout.adapter_user, parentView, false);
		} else {
			insight = (LinearLayout) itemView;
		}
		
		u = this._users.get(position);
		
		// Set associated picture and name
		pic = (ImageView) insight.findViewById(R.id.adapter_user_picture);
		name = (TextView) insight.findViewById(R.id.adapter_user_name);		
		UserPictureGetter.get(u, pic);
		name.setText(u.getFirstName());
		insight.setTag(u.getId());
		
		// On click, display insight for specified user
		insight.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent;
				
				intent = new Intent(_context, UserActivity.class);
				intent.putExtra("user-id", (String) v.getTag());
				_context.startActivity(intent);
			}
		});
		
		return insight;
	}
}
