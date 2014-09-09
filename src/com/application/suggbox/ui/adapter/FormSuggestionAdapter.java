package com.application.suggbox.ui.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.application.suggbox.R;
import com.application.suggbox.model.bean.Interest;

public class FormSuggestionAdapter extends BaseAdapter {
	private List<Interest> _interests;
	private boolean[] _itemStates;
	
	private Context _context;
	
	private LayoutInflater _inflater;
	
	public FormSuggestionAdapter(Context context, List<Interest> interests) {
		this._context = context;
		this._interests = interests;
		this._itemStates = new boolean[this._interests.size()]; 
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
		CheckBox checkbox;
		
		if (itemView == null) {
			insight = (LinearLayout) this._inflater.inflate(R.layout.adapter_form_suggestion, parentView, false);
		} else {
			insight = (LinearLayout) itemView;
		}
		
		i = this._interests.get(position);
		checkbox = (CheckBox) insight.findViewById(R.id.adapter_form_suggestion_checkbox);
		checkbox.setText(i.getLabel());
		checkbox.setTag(position);
		
		checkbox.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				CheckBox c;
				int index;
				
				c = (CheckBox) v;
				index = Integer.parseInt(c.getTag().toString());
				
				_itemStates[index] = c.isChecked();
			}
		});
		
		return insight;
	}
	
	public List<Interest> getCheckedInterests() {
		List<Interest> outcome;
		
		outcome = new ArrayList<Interest>();
		
		for (int i = 0; i < this._itemStates.length; i++) {
			Log.d("foo", Boolean.toString(this._itemStates[i]));
			if (this._itemStates[i]) {
				outcome.add(this._interests.get(i));
			}
		}
		
		return outcome;
	}
}
