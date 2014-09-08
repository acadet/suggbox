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
import com.application.suggbox.model.bean.Suggestion;

public class SuggestionAdapter extends BaseAdapter {
	private List<Suggestion> _suggestions;
	
	private Context _context;
	
	private LayoutInflater _inflater;
	
	public SuggestionAdapter(Context context, List<Suggestion> suggestions) {
		this._context = context;
		this._suggestions = suggestions;
		this._inflater = LayoutInflater.from(this._context);
	}

	@Override
	public int getCount() {
		return this._suggestions.size();
	}

	@Override
	public Object getItem(int arg0) {
		return this._suggestions.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int position, View itemView, ViewGroup parentView) {
		LinearLayout insight;
		Suggestion s;
		TextView label;
		
		if (itemView == null) {
			insight = (LinearLayout) this._inflater.inflate(R.layout.adapter_suggestion, parentView, false);
		} else {
			insight = (LinearLayout) itemView;
		}
		
		s = this._suggestions.get(position);
		label = (TextView) insight.findViewById(R.id.adaptater_suggestion_label);
		label.setText(s.getLabel());
		
		return insight;
	}
}