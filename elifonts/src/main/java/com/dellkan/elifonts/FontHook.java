package com.dellkan.elifonts;

import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.dellkan.enhanced_layout_inflater.hooks.TypedAttributeViewHook;

public class FontHook extends TypedAttributeViewHook<TextView> {
	private String defaultPath;
	public FontHook() {
		super(TextView.class, R.styleable.TextView_Font);
	}

	public FontHook(String defaultFont) {
		super(TextView.class, R.styleable.TextView_Font);
		defaultPath = defaultFont;
	}

	@Override
	public void onViewCreated(@Nullable View parent, @NonNull TextView view, @NonNull TypedArray attrs) {
		String font = defaultPath;

		CharSequence typedFont = attrs.getText(R.styleable.TextView_Font_font);
		if (typedFont != null) {
			font = typedFont.toString();
		}

		if (font != null) {
			ELIFontsUtils.applyFont(view, ELIFontsUtils.loadFont(view.getContext(), font));
		}
	}
}
