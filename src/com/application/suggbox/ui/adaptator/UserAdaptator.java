package com.application.suggbox.ui.adaptator;

import java.util.List;

import android.R;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.application.suggbox.model.bean.User;

public class UserAdaptator extends BaseAdapter {
	private List<User> _users;
	
	private Context _context;
	
	private LayoutInflater _inflater;
	
	public UserAdaptator(Context context, List<User> users) {
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
			insight = (LinearLayout) this._inflater.inflate(R.layout.user_insight, parentView, false);
		} else {
			insight = (LinearLayout) itemView;
		}
		
		pic = (ImageView) insight.findViewById(R.id.user_insight_picture);
		name = (TextView) insight.findViewById(R.id.user_insight_name);
		
		u = this._users.get(position);
		
		pic.setImageURI(Uri.parse("drawable-mdpi/" + u.getPicture()));
		name.setText(u.getFirstName());
		
		return insight;
	}
}
