package com.application.suggbox.ui.util;

import android.widget.ImageView;

import com.application.suggbox.R;
import com.application.suggbox.model.bean.User;

/**
 * @class UserPictureGetter
 * @brief Gets picture for users
 */
public class UserPictureGetter {
	/**
	 * Hydrates provided image view using specified user
	 * @param user
	 * @param img
	 */
	public static void get(User user, ImageView img) {
		int imgId;
		
		switch (user.getPicture()) {
			case Ben:
				imgId = R.drawable.ben;
				break;
			case Clement:
				imgId = R.drawable.clement;
				break;
			case Pierre:
				imgId = R.drawable.pierre;
				break;
			default:
				imgId = R.drawable.default_user;
				break;
		}
		
		img.setImageResource(imgId);
	}
	
	/**
	 * Hydrates provided image view using specified user
	 * @param user
	 * @param img
	 */
	public static void getLarge(User user, ImageView img) {
		int imgId;
		
		switch (user.getPicture()) {
			case Ben:
				imgId = R.drawable.ben_large;
				break;
			case Clement:
				imgId = R.drawable.clement_large;
				break;
			case Pierre:
				imgId = R.drawable.pierre_large;
				break;
			default:
				imgId = R.drawable.default_user_large;
				break;
		}
		
		img.setImageResource(imgId);
	}
}
