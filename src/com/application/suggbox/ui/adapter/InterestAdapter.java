package com.application.suggbox.ui.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.application.suggbox.R;
import com.application.suggbox.model.bean.Interest;

/**
 * @class InterestAdapter
 * @brief Custom adapter. Adapts interests in user insight
 */
public class InterestAdapter {
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
	
	/**
	 * Fills wrapper using specified pattern
	 * @param wrapper
	 */
	public void adapt(ViewGroup wrapper) {
		for (Interest i : this._interests) {
			ViewGroup pattern;
			TextView label;
			
			pattern = (ViewGroup) this._inflater.inflate(R.layout.adapter_interest, null);
			label = (TextView) pattern.findViewById(R.id.adapter_interest_label);
			label.setText(i.getLabel());
			
			wrapper.addView(pattern);
		}
	}
}