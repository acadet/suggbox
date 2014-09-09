package com.application.suggbox.ui.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.application.suggbox.R;
import com.application.suggbox.model.bean.Interest;

/**
 * @class InterestAdapter
 * @brief Adapts interests in user insight
 */
public class InterestAdapter extends BaseAdapter {
	/**
	 * Current interests
	 */
	private List<Interest> _interests;
	
	/**
	 * Current context
	 */
	private Context _context;
	
	/**
	 * Current inflater
	 */
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
		label = (TextView) insight.findViewById(R.id.adapter_interest_label);
		label.setText(i.getLabel());
		
		return insight;
	}
}