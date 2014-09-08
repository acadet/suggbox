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
import com.application.suggbox.model.bean.Interest;
import com.application.suggbox.model.bean.User;
import com.application.suggbox.ui.activity.UserActivity;

public class InterestAdapter extends BaseAdapter {
	private List<Interest> _interests;
	
	private Context _context;
	
	private LayoutInflater _inflater;
	
	public InterestAdapter(Context context, List<Interest> interests) {
		this._context = context;
		this._interests = interests;
		this._inflater = LayoutInflater.from(this._context);
	}

	@Override
	public int getCount() {
		return this._interests.size();
	}

	@Override
	public Object getItem(int arg0) {
		return this._interests.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int position, View itemView, ViewGroup parentView) {
		LinearLayout insight;
		Interest i;
		TextView label;
		
		if (itemView == null) {
			insight = (LinearLayout) this._inflater.inflate(R.layout.adapter_interest, parentView, false);
		} else {
			insight = (LinearLayout) itemView;
		}
		
		i = this._interests.get(position);
		label = (TextView) insight.findViewById(R.id.adaptator_interest_label);
		label.setText(i.getLabel());
		
		return insight;
	}
}