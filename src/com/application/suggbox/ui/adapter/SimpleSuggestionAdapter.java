package com.application.suggbox.ui.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.application.suggbox.R;
import com.application.suggbox.model.bean.Suggestion;
import com.application.suggbox.model.bll.ISuggestionBusiness;

/**
 * @class SimpleSuggestionAdapter
 * @brief Custom adapter. Adapts suggestions in user insight
 */
public class SimpleSuggestionAdapter {
	/**
	 * Current suggestion business
	 */
	private ISuggestionBusiness _suggestionBusiness;
	
	/**
	 * Current suggestions
	 */
	private List<Suggestion> _suggestions;
	
	/**
	 * Current context
	 */
	private Context _context;
	
	/**
	 * Current inflater
	 */
	private LayoutInflater _inflater;
	
	public SimpleSuggestionAdapter(
			Context context,
			List<Suggestion> suggestions,
			ISuggestionBusiness suggestionBusiness) {
		
		this._context = context;
		this._suggestions = suggestions;
		this._inflater = LayoutInflater.from(this._context);
		this._suggestionBusiness = suggestionBusiness;
	}
	
	/**
	 * Fills wrapper using specified pattern.
	 * @param wrapper
	 * @param defaultContent Default content to use if no entries
	 */
	public void adapt(ViewGroup wrapper, View defaultContent) {
		
		if (this._suggestions.size() < 1) {
			// No entries
			defaultContent.setVisibility(View.VISIBLE);
			defaultContent.invalidate();
			return;
		}
		
		for (Suggestion s : this._suggestions) {
			ViewGroup pattern;
			TextView label;
			ImageView trigger;
			
			pattern = (ViewGroup) this._inflater.inflate(R.layout.adapter_simple_suggestion, null);
			
			label = (TextView) pattern.findViewById(R.id.adapter_simple_suggestion_label);
			label.setText(s.getLabel());
			
			trigger = (ImageView) pattern.findViewById(R.id.adapter_simple_suggestion_img);
			trigger.setTag(s);
			// Img triggers deletion
			trigger.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					ViewGroup parent;
					
					_suggestionBusiness.delete((Suggestion) v.getTag());
					// Remove from display
					parent = (ViewGroup) v.getParent();
					((ViewGroup) parent.getParent()).removeView(parent);
				}
			});
			
			wrapper.addView(pattern);
		}
	}
}