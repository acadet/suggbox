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
}
