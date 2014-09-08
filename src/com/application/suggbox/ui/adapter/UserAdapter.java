package com.application.suggbox.ui.adapter;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.sax.StartElementListener;
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

public class UserAdapter extends BaseAdapter {
	private List<User> _users;
	
	private Context _context;
	
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
		int imageId;
		User u;
		
		if (itemView == null) {
			insight = (LinearLayout) this._inflater.inflate(R.layout.adapter_user, parentView, false);
		} else {
			insight = (LinearLayout) itemView;
		}
		
		pic = (ImageView) insight.findViewById(R.id.adaptator_user_picture);
		name = (TextView) insight.findViewById(R.id.adaptator_user_name);
		
		u = this._users.get(position);
		
		switch (u.getPicture()) {
			case Ben:
				imageId = R.drawable.ben;
				break;
			case Clement:
				imageId = R.drawable.clement;
				break;
			case Pierre:
				imageId = R.drawable.pierre;
				break;
			default:
				imageId = R.drawable.default_user;
				break;
		}
		
		pic.setImageResource(imageId);		
		name.setText(u.getFirstName());
		insight.setTag(u.getId());
		
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
