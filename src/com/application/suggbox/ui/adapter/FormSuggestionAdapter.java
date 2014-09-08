package com.application.suggbox.ui.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.application.suggbox.R;
import com.application.suggbox.model.bean.Interest;

public class FormSuggestionAdapter extends BaseAdapter {
	private List<Interest> _interests;
	
	private Context _context;
	
	private LayoutInflater _inflater;
	
	public FormSuggestionAdapter(Context context, List<Interest> interests) {
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
		CheckBox checkbox;
		
		if (itemView == null) {
			insight = (LinearLayout) this._inflater.inflate(R.layout.adapter_form_suggestion, parentView, false);
		} else {
			insight = (LinearLayout) itemView;
		}
		
		i = this._interests.get(position);
		checkbox = (CheckBox) insight.findViewById(R.id.adapter_form_suggestion_checkbox);
		checkbox.setText(i.getLabel());
		
		return insight;
	}
}
