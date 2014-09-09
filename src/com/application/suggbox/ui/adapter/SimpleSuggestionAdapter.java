package com.application.suggbox.ui.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.application.suggbox.R;
import com.application.suggbox.model.bean.Suggestion;
import com.application.suggbox.model.bll.BusinessFactory;
import com.application.suggbox.model.bll.ISuggestionBusiness;

public class SimpleSuggestionAdapter extends BaseAdapter {
	private ISuggestionBusiness _suggestionBusiness;
	private List<Suggestion> _suggestions;
	
	private Context _context;
	
	private LayoutInflater _inflater;
	
	public SimpleSuggestionAdapter(Context context, List<Suggestion> suggestions) {
		this._context = context;
		this._suggestions = suggestions;
		this._inflater = LayoutInflater.from(this._context);
		this._suggestionBusiness = new BusinessFactory().suggestion(this._context);
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
		ImageView img;
		
		if (itemView == null) {
			insight = (LinearLayout) this._inflater.inflate(R.layout.adapter_simple_suggestion, parentView, false);
		} else {
			insight = (LinearLayout) itemView;
		}
		
		s = this._suggestions.get(position);
		label = (TextView) insight.findViewById(R.id.adapter_simple_suggestion_label);
		label.setText(s.getLabel());
		
		img = (ImageView) insight.findViewById(R.id.adapter_simple_suggestion_img);
		img.setTag(s);
		img.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ImageView img;
				Suggestion target;
				
				img = (ImageView) v;
				target = (Suggestion) img.getTag();
				_suggestionBusiness.delete(target);
				_suggestions.remove(target);
				notifyDataSetChanged();
			}
		});
		
		return insight;
	}
}